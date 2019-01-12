package ch.hsr.cloud.selfinformation.providers;

import java.util.ArrayList;

import ch.hsr.cloud.selfinformation.properties.HardwareInformationProperties;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class HardwareInformation extends InformationProvider {
	private HardwareInformationProperties hw = new HardwareInformationProperties();

	public HardwareInformation() {
		init();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#init()
	 */
	@Override
	protected void init() {
		this.information = this.hw.getProperties();	
	}
	
	/* (non-Javadoc)
	 * @see ch.hsr.bll.SelfInformation#toString()
	 */
	@Override
	public String toString() {
		return "HardwareInformation";
	}

	/**
	 * @return long value with free allocated JVM memory
	 */
	public long getFreeMemory() {
		return Long.parseLong(this.information.get("Free memory (megabytes)"));
	}

	/**
	 * @return long value with max allocatable JVM memory
	 */
	public long getMaxMemory() {
		return Long.parseLong(this.information.get("Maximum memory (megabytes)"));
	}

	/**
	 * @returnint value with number of processor cores
	 */
	public int getNumOfCores() {
		return Integer.parseInt(this.information.get("Available processors (cores)"));
	}

	/**
	 * @return long value with total JVM allocated memory
	 */
	public long getTotalMemory() {
		return Long.parseLong(this.information.get("Total memory (megabytes)"));
	}

	/**
	 * @return ArrayList<String> with freespace of each filesystem
	 */
	//can't use information due to unknown count of disks
	public ArrayList<String> getFreeSpace() {
		return this.hw.getFreeSpace();
	}
}
