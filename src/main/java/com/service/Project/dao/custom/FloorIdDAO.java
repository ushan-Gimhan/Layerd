package com.service.Project.dao.custom;

import com.service.Project.dao.CrudDAO;
import com.service.Project.entity.Floor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FloorIdDAO extends CrudDAO<Floor> {
    ArrayList<String> getFloors() throws SQLException, ClassNotFoundException;
}
