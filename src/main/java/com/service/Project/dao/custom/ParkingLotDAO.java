package com.service.Project.dao.custom;

import com.service.Project.dao.CrudDAO;
import com.service.Project.entity.ParkingLot;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ParkingLotDAO extends CrudDAO<ParkingLot> {
     public ArrayList<String> getAllLotIds() throws SQLException, ClassNotFoundException;

}
