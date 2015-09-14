package com.ibm.ldap.connectors;
		
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import com.ibm.connectors.AbstractInputConnector;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.InputConnector;

public class LDAPInputConnector extends AbstractInputConnector implements InputConnector {
	
	private boolean isStarted = false;

	@Override
	public boolean isStarted() {
		return isStarted ;
	}

	@Override
	public void start() throws ConnectorException {
		
		long delay           = Long.parseLong(getProperty("delay"));
		
		if(delay==0){
		  delay=2000;
		};
		
		final String message = getProperty("message");
		
		Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				if (isStarted) {
					byte[] data = message.getBytes(StandardCharsets.UTF_8);
					Properties props = new Properties();
					String now = Calendar.getInstance().getTime().toString();
					props.setProperty("now", now);
					getLogger().fine("Ticking @ " + now);
					LDAPInputConnector.this.getCallback().processInboundData(data, props);
					getLogger().fine("Ticked");
				}
			}
			
		}, delay, delay, TimeUnit.MILLISECONDS);
		
		isStarted = true;
	}

	@Override
	public void stop() throws ConnectorException {
		isStarted = false;
	}

}
