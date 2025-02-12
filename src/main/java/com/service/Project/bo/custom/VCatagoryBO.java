package com.service.Project.bo.custom;

import com.service.Project.Model.VechicleCatagoryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VCatagoryBO {
    ArrayList<VechicleCatagoryDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(VechicleCatagoryDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(VechicleCatagoryDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
    ArrayList<String> getAllCatagoryIds() throws SQLException, ClassNotFoundException;
    VechicleCatagoryDto FindById(String id) throws SQLException, ClassNotFoundException;
}
