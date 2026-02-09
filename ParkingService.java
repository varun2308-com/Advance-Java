package com.codegnan.service;

import java.util.List;

import com.codegnan.exceptions.ParkingSlotNotFoundException;
import com.codegnan.pojo.ParkingSlot;

public interface ParkingService {
	void addSlot(ParkingSlot slot);
	List<ParkingSlot> getAllSlots();
	ParkingSlot getSlotById(int id) throws ParkingSlotNotFoundException;
	void updateSlot(ParkingSlot slot) throws ParkingSlotNotFoundException;
	void deleteSlot(int id) throws ParkingSlotNotFoundException;
}

