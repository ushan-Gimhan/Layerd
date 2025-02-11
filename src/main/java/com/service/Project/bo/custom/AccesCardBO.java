package com.service.Project.bo.custom;

import com.service.Project.Model.AccessCardDto;
import com.service.Project.Model.VechicleDto;
import com.service.Project.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AccesCardBO extends SuperBO {
    ArrayList<AccessCardDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(AccessCardDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(AccessCardDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
}
