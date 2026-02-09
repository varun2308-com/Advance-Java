package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.ParkingDao;
import com.codegnan.dao.ParkingDaoImpl;
import com.codegnan.exceptions.ParkingSlotNotFoundException;
import com.codegnan.pojo.ParkingSlot;

public class ParkingServiceImpl implements ParkingService {

	ParkingDao dao = new ParkingDaoImpl();

	public void addSlot(ParkingSlot slot) {
		dao.insert(slot);
	}

	public List<ParkingSlot> getAllSlots() {
		return dao.findAll();
	}

	public ParkingSlot getSlotById(int id) throws ParkingSlotNotFoundException {
		return dao.findById(id);
	}

	public void updateSlot(ParkingSlot slot) throws ParkingSlotNotFoundException {
		dao.update(slot);
	}

	public void deleteSlot(int id) throws ParkingSlotNotFoundException {
		dao.deleteById(id);
	}
}

