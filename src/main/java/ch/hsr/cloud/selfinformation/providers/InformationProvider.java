package ch.hsr.cloud.selfinformation.providers;

import java.util.LinkedHashMap;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public abstract class InformationProvider {
	protected LinkedHashMap<String, String> information;
	
	/**
	 * used for (re-)initialization of the class
	 */
	protected abstract void init();
	
	/**
	 * @returns name of information as string
	 */
	public abstract String toString();
	
	public LinkedHashMap<String, String> getInformation() {
		return this.information;
	}
}
