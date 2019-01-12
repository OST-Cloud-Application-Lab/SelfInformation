package ch.hsr.cloud.selfinformation.properties;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class HardwareInformationProperties implements SelfInformationProperties {
	private LinkedHashMap<String, String> hardware = new LinkedHashMap<String, String>();
	private int numOfCores;
	private long freeMemory;
	private long maxMemory;
	private long totalMemory;
	private ArrayList<String> freeSpace;
	
	public HardwareInformationProperties() {
		collectHardwareInformation();
	}
	
	private void collectHardwareInformation() {
		collectProcessorAndMemoryInformation();
		collectHarddiskInformation();
	}
	
	private void collectProcessorAndMemoryInformation() {
		setNumOfCores(Runtime.getRuntime().availableProcessors());
		setMaxMemory(Runtime.getRuntime().maxMemory() / (1024*1024));
		setFreeMemory(Runtime.getRuntime().freeMemory() / (1024*1024));
		setTotalMemory(Runtime.getRuntime().totalMemory() / (1024 * 1024));
		
		this.hardware.put("Available processors (cores)", Integer.toString(getNumOfCores()));
		this.hardware.put("Free memory (megabytes)", Long.toString(getFreeMemory()));
		this.hardware.put("Maximum memory (megabytes)", (getMaxMemory() == Long.MAX_VALUE ? "no limit" : Long.toString(getMaxMemory())));
		this.hardware.put("Total memory (megabytes)", Long.toString(getTotalMemory()));
	}
	
	private void collectHarddiskInformation() {
		File[] roots = File.listRoots();
		setFreeSpace(new ArrayList<String>());
		for (File root : roots) {
			String path = root.getAbsolutePath();
			String freeSpace = Long.toString(root.getFreeSpace() / (1024 * 1024));
			this.hardware.put(path + " Total space (megabytes)",Long.toString(root.getTotalSpace() / (1024 * 1024)));
			this.hardware.put(path + " Free space (megabytes)" ,freeSpace);
			getFreeSpace().add(path + " Free space (megabytes) : " + freeSpace);
			this.hardware.put(path + " Usable space (megabytes)", Long.toString(root.getUsableSpace() / (1024 * 1024)));
		}
	}
	
	/**
	 * @param numOfCores
	 */
	private void setNumOfCores(int numOfCores) {
		this.numOfCores = numOfCores;
	}
	
	/**
	 * @param freeMemory
	 */
	private void setFreeMemory(long freeMemory) {
		this.freeMemory = freeMemory;
	}

	/**
	 * @param maxMemory
	 */
	private void setMaxMemory(long maxMemory) {
		this.maxMemory = maxMemory;
	}
	
	/**
	 * @param totalMemory
	 */
	private void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	/**
	 * @param freeSpace
	 */
	private void setFreeSpace(ArrayList<String> freeSpace) {
		this.freeSpace = freeSpace;
	}
	
	@Override
	public LinkedHashMap<String, String> getProperties() {
		return this.hardware;
	}

	/**
	 * @return int value containing number of processor cores
	 */
	public int getNumOfCores() {
		return this.numOfCores;
	}

	/**
	 * @return long value with free allocated JVM memory
	 */
	public long getFreeMemory() {
		return this.freeMemory;
	}

	/**
	 * @return long value with max allocatable JVM memory
	 */
	public long getMaxMemory() {
		return this.maxMemory;
	}

	/**
	 * @return long value with total allocatable JVM memory
	 */
	public long getTotalMemory() {
		return this.totalMemory;
	}

	/**
	 * @return ArrayList<String> with freespace of each filesystem
	 */
	public ArrayList<String> getFreeSpace() {
		return this.freeSpace;
	}
}
