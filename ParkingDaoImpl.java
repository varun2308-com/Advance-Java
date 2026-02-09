package com.codegnan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.connection.ConnectionFactory;
import com.codegnan.exceptions.ParkingSlotNotFoundException;
import com.codegnan.pojo.ParkingSlot;

public class ParkingDaoImpl implements ParkingDao {

	public void insert(ParkingSlot slot) {
		String sql = "INSERT INTO parking_slots VALUES(?,?,?,?)";
		try (Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, slot.getSlotId());
			ps.setString(2, slot.getVehicleType());
			ps.setString(3, slot.getStatus());
			ps.setDouble(4, slot.getHourlyRate());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ParkingSlot> findAll() {
		List<ParkingSlot> list = new ArrayList<>();
		String sql = "SELECT * FROM parking_slots";

		try (Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				list.add(new ParkingSlot(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ParkingSlot findById(int id) throws ParkingSlotNotFoundException {
		String sql = "SELECT * FROM parking_slots WHERE slot_id=?";
		try (Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new ParkingSlot(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4));
			} else {
				throw new ParkingSlotNotFoundException("Slot Not Found: " + id);
			}
		} catch (SQLException e) {
			throw new ParkingSlotNotFoundException(e.getMessage());
		}
	}

	public void update(ParkingSlot slot) throws ParkingSlotNotFoundException {
		String sql = "UPDATE parking_slots SET vehicle_type=?, status=?, hourly_rate=? WHERE slot_id=?";
		try (Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, slot.getVehicleType());
			ps.setString(2, slot.getStatus());
			ps.setDouble(3, slot.getHourlyRate());
			ps.setInt(4, slot.getSlotId());

			if (ps.executeUpdate() == 0) {
				throw new ParkingSlotNotFoundException("Slot Not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteById(int id) throws ParkingSlotNotFoundException {
		String sql = "DELETE FROM parking_slots WHERE slot_id=?";
		try (Connection con = ConnectionFactory.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			if (ps.executeUpdate() == 0) {
				throw new ParkingSlotNotFoundException("Slot Not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

