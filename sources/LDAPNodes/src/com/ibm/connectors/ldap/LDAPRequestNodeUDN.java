package com.ibm.connectors.ldap;

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>LDAPRequestNodeUDN</I> instance</p>
 * <p></p>
 */
public class LDAPRequestNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/connectors/ldap/RequestNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/LDAPNodes/icons/full/obj16/com/ibm/connectors/ldap/ComIbmRequest.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/LDAPNodes/icons/full/obj30/com/ibm/connectors/ldap/ComIbmRequest.gif";

	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_HOSTNAME = "hostname";
	protected final static String PROPERTY_PORT = "port";
	protected final static String PROPERTY_BINDUSERNAME = "bindUserName";
	protected final static String PROPERTY_BINDUSERPASSWORD = "bindUserPassword";
	protected final static String PROPERTY_SEARCHBASE = "searchBase";
	protected final static String PROPERTY_USERFILTER = "userFilter";
	protected final static String PROPERTY_ATTRIBUTES = "attributes";
	protected final static String PROPERTY_MESSAGEDOMAINPROPERTY = "messageDomainProperty";
	protected final static String PROPERTY_MESSAGESETPROPERTY = "messageSetProperty";
	protected final static String PROPERTY_MESSAGETYPEPROPERTY = "messageTypeProperty";
	protected final static String PROPERTY_MESSAGEFORMATPROPERTY = "messageFormatProperty";

	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "LDAP","","",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_HOSTNAME,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_PORT,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, "389","","",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_BINDUSERNAME,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_BINDUSERPASSWORD,		NodeProperty.Usage.MANDATORY,	true,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_SEARCHBASE,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "O=","","",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_USERFILTER,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, "(&(objectClass=person)(uid=%v))","","",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_ATTRIBUTES,		NodeProperty.Usage.MANDATORY,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageDomainPropertyEditor",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_MESSAGESETPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageSetNamePropertyEditorV8",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_MESSAGETYPEPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageTypePropertyEditorV8",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes"),
			new NodeProperty(LDAPRequestNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"",	"com.ibm.etools.mft.ibmnodes.editors.MRMessageFormatPropertyEditor",	"com/ibm/connectors/ldap/ComIbmRequest",	"LDAPNodes")
		};
	}

	public LDAPRequestNodeUDN() {
	}

	public final InputTerminal INPUT_TERMINAL_IN = new InputTerminal(this,"InTerminal.in");
	@Override
	public InputTerminal[] getInputTerminals() {
		return new InputTerminal[] {
			INPUT_TERMINAL_IN
	};
	}

	public final OutputTerminal OUTPUT_TERMINAL_OUT = new OutputTerminal(this,"OutTerminal.out");
	public final OutputTerminal OUTPUT_TERMINAL_FAILURE = new OutputTerminal(this,"OutTerminal.failure");
	@Override
	public OutputTerminal[] getOutputTerminals() {
		return new OutputTerminal[] {
			OUTPUT_TERMINAL_OUT,
			OUTPUT_TERMINAL_FAILURE
		};
	}

	@Override
	public String getTypeName() {
		return NODE_TYPE_NAME;
	}

	protected String getGraphic16() {
		return NODE_GRAPHIC_16;
	}

	protected String getGraphic32() {
		return NODE_GRAPHIC_32;
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>connectorName</I>"
	 */
	public LDAPRequestNodeUDN setConnectorName(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @return String; the value of the property "<I>connectorName</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>Host name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Host name</I>"
	 */
	public LDAPRequestNodeUDN setHostname(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_HOSTNAME, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>Host name</I>" property
	 * 
	 * @return String; the value of the property "<I>Host name</I>"
	 */
	public String getHostname() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_HOSTNAME);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>Port</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Port</I>"
	 */
	public LDAPRequestNodeUDN setPort(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_PORT, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>Port</I>" property
	 * 
	 * @return String; the value of the property "<I>Port</I>"
	 */
	public String getPort() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_PORT);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>Bind user name</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Bind user name</I>"
	 */
	public LDAPRequestNodeUDN setBindUserName(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_BINDUSERNAME, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>Bind user name</I>" property
	 * 
	 * @return String; the value of the property "<I>Bind user name</I>"
	 */
	public String getBindUserName() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_BINDUSERNAME);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>Bind user password</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Bind user password</I>"
	 */
	public LDAPRequestNodeUDN setBindUserPassword(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_BINDUSERPASSWORD, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>Bind user password</I>" property
	 * 
	 * @return String; the value of the property "<I>Bind user password</I>"
	 */
	public String getBindUserPassword() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_BINDUSERPASSWORD);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>Search base</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Search base</I>"
	 */
	public LDAPRequestNodeUDN setSearchBase(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_SEARCHBASE, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>Search base</I>" property
	 * 
	 * @return String; the value of the property "<I>Search base</I>"
	 */
	public String getSearchBase() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_SEARCHBASE);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>User filter</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>User filter</I>"
	 */
	public LDAPRequestNodeUDN setUserFilter(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_USERFILTER, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>User filter</I>" property
	 * 
	 * @return String; the value of the property "<I>User filter</I>"
	 */
	public String getUserFilter() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_USERFILTER);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>attributes</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>attributes</I>"
	 */
	public LDAPRequestNodeUDN setAttributes(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_ATTRIBUTES, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>attributes</I>" property
	 * 
	 * @return String; the value of the property "<I>attributes</I>"
	 */
	public String getAttributes() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_ATTRIBUTES);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>Message domain</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Message domain</I>"
	 */
	public LDAPRequestNodeUDN setMessageDomainProperty(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>Message domain</I>" property
	 * 
	 * @return String; the value of the property "<I>Message domain</I>"
	 */
	public String getMessageDomainProperty() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_MESSAGEDOMAINPROPERTY);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>messageSetProperty</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>messageSetProperty</I>"
	 */
	public LDAPRequestNodeUDN setMessageSetProperty(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_MESSAGESETPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>messageSetProperty</I>" property
	 * 
	 * @return String; the value of the property "<I>messageSetProperty</I>"
	 */
	public String getMessageSetProperty() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_MESSAGESETPROPERTY);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>messageTypeProperty</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>messageTypeProperty</I>"
	 */
	public LDAPRequestNodeUDN setMessageTypeProperty(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_MESSAGETYPEPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>messageTypeProperty</I>" property
	 * 
	 * @return String; the value of the property "<I>messageTypeProperty</I>"
	 */
	public String getMessageTypeProperty() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_MESSAGETYPEPROPERTY);
	}

	/**
	 * Set the <I>LDAPRequestNodeUDN</I> "<I>messageFormatProperty</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>messageFormatProperty</I>"
	 */
	public LDAPRequestNodeUDN setMessageFormatProperty(String value) {
		setProperty(LDAPRequestNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY, value);
		return this;
	}

	/**
	 * Get the <I>LDAPRequestNodeUDN</I> "<I>messageFormatProperty</I>" property
	 * 
	 * @return String; the value of the property "<I>messageFormatProperty</I>"
	 */
	public String getMessageFormatProperty() {
		return (String)getPropertyValue(LDAPRequestNodeUDN.PROPERTY_MESSAGEFORMATPROPERTY);
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "LDAP Request";
		return retVal;
	};
}
