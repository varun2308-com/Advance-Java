package com.codegnan.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codegnan.entity.ParkingSlot;
import com.codegnan.exceptions.InvalidSlotIdException;
import com.codegnan.helper.ConnectionFactoryHelper;

public class ParkingSlotDaoImpl implements ParkingSlotDao {

    private SessionFactory sessionFactory =
            ConnectionFactoryHelper.getSessionFactory();

    @Override
    public int save(ParkingSlot slot) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id = (int) session.save(slot);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public List<ParkingSlot> findAll() {
        Session session = sessionFactory.openSession();
        List<ParkingSlot> list =
                session.createQuery("from ParkingSlot", ParkingSlot.class).list();
        session.close();
        return list;
    }

    @Override
    public ParkingSlot findById(int id) throws InvalidSlotIdException {
        Session session = sessionFactory.openSession();
        ParkingSlot slot = session.find(ParkingSlot.class, id);
        session.close();

        if (slot == null)
            throw new InvalidSlotIdException("Invalid Slot ID: " + id);

        return slot;
    }

    @Override
    public void update(ParkingSlot slot) throws InvalidSlotIdException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ParkingSlot existing =
                session.find(ParkingSlot.class, slot.getSlotId());

        if (existing == null)
            throw new InvalidSlotIdException("Slot not found: " + slot.getSlotId());

        existing.setVehicleNumber(slot.getVehicleNumber());
        existing.setVehicleType(slot.getVehicleType());
        existing.setOwnerName(slot.getOwnerName());
        existing.setStatus(slot.getStatus());

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) throws InvalidSlotIdException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ParkingSlot slot = session.find(ParkingSlot.class, id);

        if (slot == null)
            throw new InvalidSlotIdException("Slot not found: " + id);

        session.delete(slot);
        session.getTransaction().commit();
        session.close();
    }
}