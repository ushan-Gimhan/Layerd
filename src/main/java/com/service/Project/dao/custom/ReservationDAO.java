package com.service.Project.dao.custom;

import com.service.Project.dao.CrudDAO;
import com.service.Project.entity.AllReservation;
import com.service.Project.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationDAO extends CrudDAO<Reservation> {
    ArrayList<AllReservation> getAllTableData() throws SQLException ,ClassNotFoundException;
    ArrayList<String> getAllIds() throws SQLException ,ClassNotFoundException;
}
