package task2;

public class SystemInf {
	private String os;
	private String cpuFreq;
	private String video;
	private String core;
	private int requestNum;
	public SystemInf(String os, String cpuFreq, String video, String core) {
		super();
		this.os = os;
		this.cpuFreq = cpuFreq;
		this.video = video;
		this.core = core;
		requestNum = 0;
	}
	public SystemInf() {
		super();
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getCpuFreq() {
		return cpuFreq;
	}
	public void setCpuFreq(String cpuFreq) {
		this.cpuFreq = cpuFreq;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	
	@Override
	public String toString() {
		requestNum++;
		return("Operation system: " + this.os + System.lineSeparator() 
				+ "CPU freqency: " + this.cpuFreq + System.lineSeparator() 
				+ "Videocard: " + this.video + System.lineSeparator() 
				+ "Core: " + this.core + System.lineSeparator() 
				+ "Request number: " + requestNum);
	}
}
