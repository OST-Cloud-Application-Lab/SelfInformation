package ch.hsr.cloud.selfinformation.properties;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 * 
 */
public class NetworkInformationProperties implements SelfInformationProperties {
	private LinkedHashMap<String, String> network = new LinkedHashMap<String, String>();

	public NetworkInformationProperties() throws SocketException {
		collectNetworkProperties();
	}

	private void collectNetworkProperties() throws SocketException {
		Enumeration<NetworkInterface> nets = NetworkInterface
				.getNetworkInterfaces();
		ArrayList<NetworkInterface> list = Collections.list(nets);
		for (int i = 0; i < list.size(); i++) {
			NetworkInterface netint = list.get(i);
			this.network.put("Display name " + i, netint.getDisplayName());
			this.network.put("Name " + i, netint.getName());
			Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
			String addresses = "";
			for (InetAddress inetAddress : Collections.list(inetAddresses)) {
				if(inetAddress instanceof Inet4Address) {
					addresses += inetAddress.toString() + " ";
				}
			}
			this.network.put("InetAddresses " + i, addresses);
		}
	}

	@Override
	public LinkedHashMap<String, String> getProperties() {
		return this.network;
	}

}
