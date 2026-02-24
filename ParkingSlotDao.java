package com.codegnan.dao;

import java.util.List;
import com.codegnan.entity.ParkingSlot;
import com.codegnan.exceptions.InvalidSlotIdException;

public interface ParkingSlotDao {

    int save(ParkingSlot slot);

    List<ParkingSlot> findAll();

    ParkingSlot findById(int id) throws InvalidSlotIdException;

    void update(ParkingSlot slot) throws InvalidSlotIdException;

    void delete(int id) throws InvalidSlotIdException;
}
