package sample.test.designPatterns.model;

public class Server extends Computer {
	private String ram;
	private String hdd;
	private String cpuCores;

	public Server(String ram, String hdd, String cpuCores) {
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
