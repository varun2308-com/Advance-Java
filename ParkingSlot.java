package com.codegnan.pojo;

public class ParkingSlot {
	private int slotId;
	private String vehicleType;
	private String status;
	private double hourlyRate;

	public ParkingSlot() {}

	public ParkingSlot(int slotId, String vehicleType, String status, double hourlyRate) {
		this.slotId = slotId;
		this.vehicleType = vehicleType;
		this.status = status;
		this.hourlyRate = hourlyRate;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String toString() {
		return "ParkingSlot [slotId=" + slotId + ", vehicleType=" + vehicleType +
				", status=" + status + ", hourlyRate=" + hourlyRate + "]";
	}
}

