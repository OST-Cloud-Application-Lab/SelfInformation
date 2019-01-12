package ch.hsr.cloud.selfinformation.providers;

import ch.hsr.cloud.selfinformation.properties.SystemProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 * 
 */
public class SystemInformation extends InformationProvider {

	private static final String JAVA_VERSION = "java.version";
	private static final String JAVA_CLASS_PATH = "java.class.path";
	private static final String JAVA_HOME = "java.home";
	private static final String USER_NAME = "user.name";
	private static final String JAVA_SPECIFICATION_VERSION = "java.specification.version";
	private static final String OS_VERSION = "os.version";
	private static final String USER_HOME = "user.home";
	private static final String FILE_ENCODING = "file.encoding";
	private static final String JAVA_CLASS_VERSION = "java.class.version";
	private static final String JAVA_LIBRARY_PATH = "java.library.path";
	private static final String JAVA_RUNTIME_VERSION = "java.runtime.version";
	private static final String USER_COUNTRY = "user.country";
	private static final String JAVA_VM_NAME = "java.vm.name";
	private static final String USER_COUNTRY_FORMAT = "user.country.format";
	private static final String JAVA_RUNTIME_NAME = "java.runtime.name";

	public SystemInformation() {
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.hsr.bll.SelfInformation#init()
	 */
	@Override
	protected void init() {
		this.information = new SystemProperties().getProperties();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.hsr.bll.SelfInformation#toString()
	 */
	@Override
	public String toString() {
		return "SystemProperties";
	}

	/**
	 * @return string or null if no java.runtime.name was found
	 */
	public String getRuntimeName() {
		return this.information.get(SystemInformation.JAVA_RUNTIME_NAME);
	}

	/**
	 * @return string or null if no user.country.format was found
	 */
	public String getUserCountryFormat() {
		return this.information.get(SystemInformation.USER_COUNTRY_FORMAT);
	}

	/**
	 * @return string or null if no java.vm.name is found
	 */
	public String getJavaVmName() {
		return this.information.get(SystemInformation.JAVA_VM_NAME);
	}

	/**
	 * @return return string or null if no user.country is found
	 */
	public String getUserCountry() {
		return this.information.get(SystemInformation.USER_COUNTRY);
	}

	/**
	 * @return string or null if no java.runtime.version is found
	 */
	public String getJavaRuntimeVersion() {
		return this.information.get(SystemInformation.JAVA_RUNTIME_VERSION);
	}

	/**
	 * @return string or null if no java.library.path is found
	 */
	public String getJavaLibraryPath() {
		return this.information.get(SystemInformation.JAVA_LIBRARY_PATH);
	}

	/**
	 * @return string or null if no java.class.version is found
	 */
	public String getJavaClassVersion() {
		return this.information.get(SystemInformation.JAVA_CLASS_VERSION);
	}

	/**
	 * @return string or null if no file.encoding is found
	 */
	public String getFileEncoding() {
		return this.information.get(SystemInformation.FILE_ENCODING);
	}

	/**
	 * @return string or null if no user.home is found
	 */
	public String getUserHome() {
		return this.information.get(SystemInformation.USER_HOME);
	}

	/**
	 * @return string or null if no os.version is found
	 */
	public String getOsVersion() {
		return this.information.get(SystemInformation.OS_VERSION);
	}

	/**
	 * @return string or null if no java.specification.version is found
	 */
	public String getJavaSpecificationVersion() {
		return this.information.get(SystemInformation.JAVA_SPECIFICATION_VERSION);
	}

	/**
	 * @return string or null if no user.name is found
	 */
	public String getUsername() {
		return this.information.get(SystemInformation.USER_NAME);
	}

	/**
	 * @return string or null if no java.home is found
	 */
	public String getJavaHome() {
		return this.information.get(SystemInformation.JAVA_HOME);
	}

	/**
	 * @return string or null if no java.class.path is found
	 */
	public String getJavaClassPath() {
		return this.information.get(SystemInformation.JAVA_CLASS_PATH);
	}

	/**
	 * @return string or null if no java.version is found
	 */
	public String getJavaVersion() {
		return this.information.get(SystemInformation.JAVA_VERSION);
	}
}
