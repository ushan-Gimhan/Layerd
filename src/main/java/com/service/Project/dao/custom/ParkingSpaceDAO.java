package com.service.Project.dao.custom;


import com.service.Project.dao.CrudDAO;
import com.service.Project.entity.ParkingSpace;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ParkingSpaceDAO extends CrudDAO<ParkingSpace>{
    ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;
}
