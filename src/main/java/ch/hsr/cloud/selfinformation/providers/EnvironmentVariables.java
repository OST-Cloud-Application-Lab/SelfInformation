package ch.hsr.cloud.selfinformation.providers;

import ch.hsr.cloud.selfinformation.properties.EnvironmentVariablesProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class EnvironmentVariables extends InformationProvider {
	private static final String USERNAME = "USERNAME";
	private static final String NUMBER_OF_PROCESSORS = "NUMBER_OF_PROCESSORS";
	private static final String COMPUTERNAME = "COMPUTERNAME";
	private static final String OS = "OS";
	private static final String LOGONSERVER = "LOGONSERVER";
	private static final String HOMEDRIVE = "HOMEDRIVE";
	private static final String PATH = "Path";
	private static final String JAVA_HOME = "JAVA_HOME";
	private static final String USERPROFILE = "USERPROFILE";
	
	public EnvironmentVariables() {
		init();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#init()
	 */
	@Override
	protected void init() {
		this.information = new EnvironmentVariablesProperties().getProperties();
	}
	
	/* (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#toString()
	 */
	@Override
	public String toString() {
		return "EnvironmentVariables";
	}

	/**
	 * @return String or null if no USERPROFILE variable is found
	 */
	public String getUserProfile() {
		return this.information.get(EnvironmentVariables.USERPROFILE);
	}

	/**
	 * @return String or null if no JAVA_HOME variable is found
	 */
	public String getJavaHome() {
		return this.information.get(EnvironmentVariables.JAVA_HOME);
	}

	/**
	 * @return String or null if no Path variable is found
	 */
	public String getPath() {
		return this.information.get(EnvironmentVariables.PATH);
	}

	/**
	 * @return String or null if no HOMEDRIVE variable is found
	 */
	public String getHomeDrive() {
		return this.information.get(EnvironmentVariables.HOMEDRIVE);
	}

	/**
	 * @return String or null if no LOGONSERVER variable is found
	 */
	public String getLogonserver() {
		return this.information.get(EnvironmentVariables.LOGONSERVER);
	}

	/**
	 * @return String or null if no OS variable is found
	 */
	public String getOS() {
		return this.information.get(EnvironmentVariables.OS);
	}

	/**
	 * @return String or null of no COMPUTERNAME variable is found
	 */
	public String getComputername() {
		return this.information.get(EnvironmentVariables.COMPUTERNAME);
	}

	/**
	 * @return String or null if no NUMBER_OF_PROCESSORS variable is found
	 */
	public String getNumberOfProcessors() {
		return this.information.get(EnvironmentVariables.NUMBER_OF_PROCESSORS);
	}

	/**
	 * @return String or null if no USERNAME variable is found
	 */
	public String getUsername() {
		return this.information.get(EnvironmentVariables.USERNAME);
	}
}
