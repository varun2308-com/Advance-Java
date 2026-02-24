package com.codegnan.service;

import java.util.List;
import com.codegnan.dao.*;
import com.codegnan.entity.ParkingSlot;
import com.codegnan.exceptions.InvalidSlotIdException;

public class ParkingSlotServiceImpl implements ParkingSlotService {

    private ParkingSlotDao dao = new ParkingSlotDaoImpl();

    @Override
    public int addSlot(ParkingSlot slot) {
        return dao.save(slot);
    }

    @Override
    public ParkingSlot getSlotById(int id)
            throws InvalidSlotIdException {
        return dao.findById(id);
    }

    @Override
    public List<ParkingSlot> getAllSlots() {
        return dao.findAll();
    }

    @Override
    public void updateSlot(ParkingSlot slot)
            throws InvalidSlotIdException {
        dao.update(slot);
    }

    @Override
    public void deleteSlot(int id)
            throws InvalidSlotIdException {
        dao.delete(id);
    }
}
