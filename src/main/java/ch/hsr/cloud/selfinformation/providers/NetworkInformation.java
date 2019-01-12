package ch.hsr.cloud.selfinformation.providers;

import java.net.SocketException;

import ch.hsr.cloud.selfinformation.properties.NetworkInformationProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class NetworkInformation extends InformationProvider {

	private static final String INET_ADDRESS = "InetAddress";

	public NetworkInformation() throws SocketException {
		init();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#init()
	 */
	@Override
	protected void init() {
		try {
			this.information = new NetworkInformationProperties().getProperties();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#toString()
	 */
	@Override
	public String toString() {
		return "NetworkInformation";
	}

	/**
	 * @return String or null if no inetaddress is found
	 */
	public String getInetAddress() {
		return this.information.get(NetworkInformation.INET_ADDRESS);
	}
}
