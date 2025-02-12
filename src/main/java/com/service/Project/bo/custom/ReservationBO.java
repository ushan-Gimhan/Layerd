package com.service.Project.bo.custom;

import com.service.Project.Model.ResavationDto;
import com.service.Project.Model.Reservationdto;
import com.service.Project.Model.VechicleCatagoryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO {
    ArrayList<ResavationDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(ResavationDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(ResavationDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
    ArrayList<Reservationdto> getAllData() throws SQLException, ClassNotFoundException;
}
