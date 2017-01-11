package ch.hsr.bll;

import java.net.SocketException;

import ch.hsr.dal.CDAR_NetworkInformationProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class CDAR_NetworkInformation extends CDAR_SelfInformation {

	private static final String INET_ADDRESS = "InetAddress";

	public CDAR_NetworkInformation() throws SocketException {
		init();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#init()
	 */
	@Override
	protected void init() {
		try {
			this.information = new CDAR_NetworkInformationProperties().getProperties();
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
		return this.information.get(CDAR_NetworkInformation.INET_ADDRESS);
	}
}
