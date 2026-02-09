package com.codegnan.dao;

import java.util.List;

import com.codegnan.exceptions.ParkingSlotNotFoundException;
import com.codegnan.pojo.ParkingSlot;

public interface ParkingDao {
	void insert(ParkingSlot slot);
	List<ParkingSlot> findAll();
	ParkingSlot findById(int id) throws ParkingSlotNotFoundException;
	void update(ParkingSlot slot) throws ParkingSlotNotFoundException;
	void deleteById(int id) throws ParkingSlotNotFoundException;
}

