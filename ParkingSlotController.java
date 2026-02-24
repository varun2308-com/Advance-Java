package com.codegnan.controller;

import java.util.List;

import com.codegnan.entity.ParkingSlot;
import com.codegnan.exceptions.InvalidSlotIdException;
import com.codegnan.service.ParkingSlotService;
import com.codegnan.service.ParkingSlotServiceImpl;

public class ParkingSlotController {

    public static void main(String[] args) {

        ParkingSlotService service = new ParkingSlotServiceImpl();

        // Insert example
        /*
        ParkingSlot s1 = new ParkingSlot("AP09AB1234",
                                          "Car",
                                          "Varun",
                                          "OCCUPIED");
        int id1 = service.addSlot(s1);

        ParkingSlot s2 = new ParkingSlot("TS10XY5678",
                                          "Bike",
                                          "Ravi",
                                          "OCCUPIED");
        int id2 = service.addSlot(s2);

        System.out.println("Slots saved successfully");
        */

        // Search by ID
        /*
        try {
            ParkingSlot fetchSlot = service.getSlotById(1);
            System.out.println(fetchSlot);
        } catch (InvalidSlotIdException e) {
            e.printStackTrace();
        }
        */

        // Fetch all records
        /*
        System.out.println("All Parking Slots");
        List<ParkingSlot> slots = service.getAllSlots();
        slots.forEach(System.out::println);
        */

        // Update record
        /*
        ParkingSlot updateSlot =
                new ParkingSlot(1,
                                "AP09AB9999",
                                "Car",
                                "Varun",
                                "AVAILABLE");

        try {
            service.updateSlot(updateSlot);
            System.out.println("Slot updated successfully");
        } catch (InvalidSlotIdException e) {
            e.printStackTrace();
        }
        */

        // Delete record
        try {
            service.deleteSlot(1);
            System.out.println("Slot deleted successfully");
        } catch (InvalidSlotIdException e) {
            e.printStackTrace();
        }
    }
}
