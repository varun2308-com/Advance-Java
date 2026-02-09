package com.codegnan.controller;

import java.util.List;

import com.codegnan.exceptions.ParkingSlotNotFoundException;
import com.codegnan.pojo.ParkingSlot;
import com.codegnan.service.ParkingService;
import com.codegnan.service.ParkingServiceImpl;

public class ParkingController {

	public static void main(String[] args) {
		ParkingService service = new ParkingServiceImpl();

	
		service.addSlot(new ParkingSlot(1, "Car", "AVAILABLE", 50));
		service.addSlot(new ParkingSlot(2, "Bike", "AVAILABLE", 20));
		service.addSlot(new ParkingSlot(3, "Truck", "OCCUPIED", 100));

		System.out.println("Parking Slots Added");


		System.out.println("\nAll Parking Slots:");
		List<ParkingSlot> slots = service.getAllSlots();
		for (ParkingSlot p : slots) {
			System.out.println(p);
		}


		try {
			System.out.println("\nFetching Slot ID 2:");
			System.out.println(service.getSlotById(2));
		} catch (ParkingSlotNotFoundException e) {
			e.printStackTrace();
		}

		
		try {
			System.out.println("\nUpdating Slot ID 3:");
			service.updateSlot(new ParkingSlot(3, "Truck", "AVAILABLE", 120));
		} catch (ParkingSlotNotFoundException e) {
			e.printStackTrace();
		}

		
		try {
			System.out.println("\nDeleting Slot ID 1");
			service.deleteSlot(1);
		} catch (ParkingSlotNotFoundException e) {
			e.printStackTrace();
		}

		
		System.out.println("\nFinal Parking Slot List:");
		for (ParkingSlot p : service.getAllSlots()) {
			System.out.println(p);
		}
	}
}

