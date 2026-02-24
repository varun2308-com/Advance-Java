package com.codegnan.service;

import java.util.List;
import com.codegnan.entity.ParkingSlot;
import com.codegnan.exceptions.InvalidSlotIdException;

public interface ParkingSlotService {

    int addSlot(ParkingSlot slot);

    ParkingSlot getSlotById(int id) throws InvalidSlotIdException;

    List<ParkingSlot> getAllSlots();

    void updateSlot(ParkingSlot slot) throws InvalidSlotIdException;

    void deleteSlot(int id) throws InvalidSlotIdException;
}
