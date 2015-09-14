package com.ibm.ldap.interaction;

import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.json.simple.JSONObject;

import com.ibm.connectors.AbstractRequestInteraction;
import com.ibm.connectors.ConnectorCallback;
import com.ibm.connectors.ConnectorException;

public class LDAPRequestInteraction extends AbstractRequestInteraction {
	
	private String ldapServer;
	private String ldapUsername;
	private String ldapPassword;
	private String ldapSearchBase;
	private String ldapUserFilter;
	private String[] ldapReturnAttributes;
	
	@Override
	public Object request(Properties properties, Object request) throws ConnectorException {
		this.fillNodeProperties(properties);
		
        byte[] requestBytes = (byte[])request; 
       
        LdapContext ctx;
        String responseMessage;  
        
		try {
			// connecting to LDAP and getting context
			ctx = this.getLdapContext();
			// get response message
			responseMessage = this.getResponseMessage(ctx, requestBytes);
		} catch (NamingException e) {
			getConnector().getLogger().severe(e.toString());
			throw new ConnectorException(e);			
		}   
		
	
		byte[] responseBytes = responseMessage.getBytes();	
		return responseBytes;
		
    }
	
	private void fillNodeProperties(Properties properties) {
		this.ldapServer = 
				new String("ldap://") + 
				properties.getProperty("hostname") + 
				new String(":") + 
				properties.getProperty("port");
		this.ldapUsername = properties.getProperty("bindUserName");
		this.ldapPassword = properties.getProperty("bindUserPassword");
		this.ldapSearchBase = properties.getProperty("searchBase");
		this.ldapUserFilter = properties.getProperty("userFilter");
		this.ldapReturnAttributes = properties.getProperty("attributes").split(",");
	}
	
	private LdapContext getLdapContext() throws NamingException {
        Hashtable<String, Object> env = new Hashtable<String, Object>();
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        if(this.ldapUsername != null) {
            env.put(Context.SECURITY_PRINCIPAL, this.ldapUsername);
        }
        if(this.ldapPassword != null) {
            env.put(Context.SECURITY_CREDENTIALS, this.ldapPassword);
        }
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapServer);
        
        // connecting to LDAP and getting context
        LdapContext ctx = new InitialLdapContext(env, null);
     	getConnector().getLogger().info( ldapServer + " connected");
     	
     	return ctx;
	}
	
	private String getResponseMessage(LdapContext ctx, byte[] requestBytes) 
			throws NamingException, ConnectorException {
		String responseMessage;
		
		// get ldapAccoun UID to lookup
        final String ldapAccountToLookup = new String(requestBytes, StandardCharsets.UTF_8);
        
		// lookup the LDAP account
		SearchResult srLdapUser = this.findAccountByAccountName(ctx, ldapSearchBase, ldapAccountToLookup);
		
		//no user data found
		if (srLdapUser == null) {    	
			getConnector().getLogger().severe("User not found");
			throw new ConnectorException("User not found");	
		} 
		
		Attributes attrs = srLdapUser.getAttributes();
		responseMessage= encodeAsJSON(attrs);	
		
		return responseMessage;
	}
    
    private SearchResult findAccountByAccountName(DirContext ctx, String ldapSearchBase, String accountName) throws NamingException, ConnectorException {

        String searchFilter = this.ldapUserFilter.replaceAll("%v", accountName);
    	
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);

        SearchResult searchResult = null;
        if(results.hasMoreElements()) {
             searchResult = (SearchResult) results.nextElement();

            //make sure there is not another item available, there should be only 1 match
            if(results.hasMoreElements()) {
                getConnector().getLogger().severe("Matched multiple users for the accountName: " + accountName);
    			throw new ConnectorException("Matched multiple users for the accountName: " + accountName);	
            }
        }
        
        return searchResult;
    }
        
	private String encodeAsJSON (Attributes userAttributes) throws NamingException {
    	JSONObject jsonObject = new JSONObject();
    	
    	for (String requestAttr: this.ldapReturnAttributes) {
    		Attribute value = userAttributes.get(requestAttr);
    		
    		if (value != null) {
    			jsonObject.put(requestAttr, value.get());
    		} else {
    			jsonObject.put(requestAttr, "null");
    		}
    	}
    	
    	return jsonObject.toJSONString();
    }
	
		
	@Override
	public long asyncRequest(Properties arg0, Object arg1, ConnectorCallback arg2) throws ConnectorException {
		return 0;
	}
	
}