package com.ibm.ldap.connectors;

import com.ibm.connectors.AbstractRequestConnector;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.RequestConnector;
import com.ibm.connectors.RequestInteraction;
import com.ibm.ldap.interaction.LDAPRequestInteraction;

public class LDAPRequestConnector extends AbstractRequestConnector implements RequestConnector {

	@Override
	public RequestInteraction createRequestInteraction() throws ConnectorException {		
		return new LDAPRequestInteraction();
	}

}