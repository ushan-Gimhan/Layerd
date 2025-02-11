package com.service.Project.bo.custom;

import com.service.Project.Model.VechicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO {
    ArrayList<VechicleDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(VechicleDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(VechicleDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
}
