package com.designpatterns.builder;

public class Computer {
	private String ram;
	private String hdd;
	private boolean isGraphicCardEnabled;
	private boolean isBluetoothEnabled;
	
	private Computer(ComputerBuilder builder) {
		this.ram = builder.ram;
		this.hdd = builder.hdd;
		this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}
	
	public String getRam() {
		return ram;
	}
	public String getHdd() {
		return hdd;
	}
	public boolean isGraphicCardEnabled() {
		return isGraphicCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	@Override
	public String toString() {
		return "ComputerBuilder [ram=" + ram + ", hdd=" + hdd + ", isGraphicCardEnabled=" + isGraphicCardEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}
	
	public static class ComputerBuilder {
		private String ram;
		private String hdd;
		private boolean isGraphicCardEnabled;
		private boolean isBluetoothEnabled;
		
		public ComputerBuilder(String ram, String hdd) {
			this.ram = ram;
			this.hdd = hdd;
		}

		public ComputerBuilder setGraphicCardEnabled(boolean isGraphicCardEnabled) {
			this.isGraphicCardEnabled = isGraphicCardEnabled;
			return this;
		}
		
		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}

}
