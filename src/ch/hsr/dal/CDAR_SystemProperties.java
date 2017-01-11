package ch.hsr.dal;

import java.util.LinkedHashMap;
import java.util.Properties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class CDAR_SystemProperties implements CDAR_SelfInformationProperties {
	private LinkedHashMap<String, String> properties = new LinkedHashMap<String, String>();
	
	public CDAR_SystemProperties() {
		collectSystemProperties();
	}

	private void collectSystemProperties() {
		Properties props = System.getProperties();
		for (String key : props .stringPropertyNames()) {
		    if (!key.isEmpty() && !props.getProperty(key).isEmpty()) {
		    	this.properties.put(key, props.getProperty(key));
		    }
		}
	}
	
	@Override
	public LinkedHashMap<String, String> getProperties() {
		return properties;
	}
}
