package com.ibm.ldap.interaction;

import java.util.Properties;

import com.ibm.connectors.AbstractOutputInteraction;
import com.ibm.connectors.ConnectorCallback;
import com.ibm.connectors.ConnectorException;

public class LDAPOutputInteraction extends AbstractOutputInteraction {

	@Override
	public long asyncSend(Properties properties, Object message, ConnectorCallback callback)
			throws ConnectorException {
		//ignore the asyncSend for now, it is not supported yet
		return 0;
	}

	@Override
	public Properties send(Properties properties, Object message)
			throws ConnectorException {
		// TODO Auto-generated method stub
		return null;
	}
	
}