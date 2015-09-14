package com.ibm.ldap.connectors;

import com.ibm.connectors.AbstractOutputConnector;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.OutputConnector;
import com.ibm.connectors.OutputInteraction;
import com.ibm.ldap.interaction.LDAPOutputInteraction;

public class LDAPOutputConnector extends AbstractOutputConnector implements OutputConnector {

	@Override
	public OutputInteraction createOutputInteraction() throws ConnectorException {
		return new LDAPOutputInteraction();
	}

}