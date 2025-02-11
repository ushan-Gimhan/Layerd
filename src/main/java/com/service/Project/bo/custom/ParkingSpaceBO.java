package com.service.Project.bo.custom;

import com.service.Project.Model.CvFormDto;
import com.service.Project.Model.ParkingSpaceDto;
import com.service.Project.View.Tm.CvFromTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ParkingSpaceBO {
    public ArrayList<ParkingSpaceDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(ParkingSpaceDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(ParkingSpaceDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    void delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
}
