package com.ibm.ldap.factory;

import com.ibm.connectors.AbstractConnectorFactory;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.InputConnector;
import com.ibm.connectors.OutputConnector;
import com.ibm.connectors.RequestConnector;
import com.ibm.ldap.connectors.LDAPInputConnector;
import com.ibm.ldap.connectors.LDAPOutputConnector;
import com.ibm.ldap.connectors.LDAPRequestConnector;

public class LDAPConnectorFactory extends AbstractConnectorFactory {

	@Override
	public InputConnector createInputConnector(String arg0)
			throws ConnectorException {
 
		return new LDAPInputConnector();
	}

	@Override
	public OutputConnector createOutputConnector(String arg0)
			throws ConnectorException {
 
		return new LDAPOutputConnector();
		
	}

	@Override
	public RequestConnector createRequestConnector(String arg0)
			throws ConnectorException {
 
		return new LDAPRequestConnector();
		
	}

	@Override
	public String getInfo() {
		return "LDAP";
	}

}
