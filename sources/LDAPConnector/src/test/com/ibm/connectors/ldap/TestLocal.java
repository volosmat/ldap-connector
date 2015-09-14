package com.ibm.connectors.ldap;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.naming.NamingException;

import com.ibm.connectors.ConnectorException;
import com.ibm.ldap.interaction.LDAPRequestInteraction;


public class TestLocal {

    /**
     * @param args the command line arguments
     * @throws ConnectorException 
     */
    public static void main(String[] args) throws NamingException, ConnectorException {
    	Properties prop = new Properties();
        prop.put("bindUserName", "cn=wasbind,o=renovations");
        prop.put("bindUserPassword", "passw0rd");
        prop.put("searchBase", "O=renovations");
        prop.put("attributes", "mail,cn,dn");
        prop.put("userFilter", "(&(objectClass=person)(uid=%v))");
        prop.put("hostname", "ttvm03.swg.usma.ibm.com");
        prop.put("port", "389");
        
        byte[] uid = "dmichaels".getBytes();
        
        LDAPRequestInteraction rInteraction = new LDAPRequestInteraction();
        byte[] response = (byte[]) rInteraction.request(prop, uid);
        System.out.println(new String(response, StandardCharsets.UTF_8));
    }
}