package com.service.Project.dao.custom.impl;

import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.ReservationDAO;
import com.service.Project.entity.AllReservation;
import com.service.Project.entity.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservatinDAOImpl implements ReservationDAO {
    @Override
    public ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean save(Reservation  resavationDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into reservation values ( ?,?,?,?,?,?,? ,?)",
                resavationDto.getResId(),
                resavationDto.getStartTime(),
                resavationDto.getEndTime(),
                resavationDto.getCustId(),
                resavationDto.getSpaceId(),
                resavationDto.getResDate(),
                resavationDto.getEndDate(),
                resavationDto.getPrice()
        );
    }

    @Override
    public boolean update(Reservation  resavationDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE reservation SET start_time = ?, end_time = ?, cust_Id = ?, space_id = ?, reservation_date = ?, end_date = ?,amount=? WHERE res_id = ?",
                resavationDto.getStartTime(),
                resavationDto.getEndTime(),
                resavationDto.getCustId(),
                resavationDto.getSpaceId(),
                resavationDto.getResDate(),
                resavationDto.getEndDate(),
                resavationDto.getPrice(),
                resavationDto.getResId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String resId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from reservation where res_id =? ",resId);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select res_id from reservation order by res_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("R%03d", newIdIndex);
        }
        return "R001";
    }

    @Override
    public ArrayList<AllReservation> getAllTableData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT reservation.res_id,customer.cust_id,parking_lot.lot_id,floor.floor_id,parking_space.space_id,reservation.reservation_date,reservation.end_date,reservation.start_time,reservation.end_time,customer.name,reservation.amount FROM customer JOIN reservation ON  customer.cust_id =reservation.cust_id JOIN parking_space ON reservation.space_id = parking_space.space_id JOIN floor ON parking_space.floor_id = floor.floor_id join parking_lot on floor.lot_id = parking_lot.lot_id");

        ArrayList<AllReservation> reservations = new ArrayList<>();
        while (result.next()) {
            AllReservation reservatio = new AllReservation(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDate(6),
                    result.getDate(7),
                    result.getTime(8),
                    result.getTime(9),
                    result.getString(10),
                    result.getDouble(11)
            );
            reservations.add(reservatio);
        }
        return reservations;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select res_id from reservation");

        // Create an ArrayList to store the item IDs
        ArrayList<String> Ids = new ArrayList<>();

        // Iterate through the result set and add each item ID to the list
        while (rst.next()) {
            Ids.add(rst.getString(1));
        }

        // Return the list of item IDs
        return Ids;
    }
}
