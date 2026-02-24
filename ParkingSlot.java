package com.codegnan.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "parking_slot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private Integer slotId;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "status")
    private String status; // AVAILABLE / OCCUPIED

    public ParkingSlot(String vehicleNumber, String vehicleType,
                       String ownerName, String status) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
        this.status = status;
    }
}
