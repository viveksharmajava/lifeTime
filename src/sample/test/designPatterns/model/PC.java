package sample.test.designPatterns.model;

public class PC extends Computer {
	private String ram ="4GB";
	private String hdd ="128GB";
	private String cpuCores = "2 Cores";
	
	public PC(String ram, String hdd, String cpuCores) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpuCores = cpuCores;
	}


	@Override
	public String getRAM() {
		return this.ram;
	}

	

	@Override
	public String getCPU() {
		return this.cpuCores;
	}



	@Override
	public String getHDD() {
		return this.hdd;
	}

}
