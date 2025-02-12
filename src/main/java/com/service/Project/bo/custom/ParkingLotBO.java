package com.service.Project.bo.custom;

import com.service.Project.Model.ParkingLotDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ParkingLotBO {
    ArrayList<ParkingLotDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(ParkingLotDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(ParkingLotDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
    ArrayList<String> getAllLotId() throws SQLException, ClassNotFoundException;
}
