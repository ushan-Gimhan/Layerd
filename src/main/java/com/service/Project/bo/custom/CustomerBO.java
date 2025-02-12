package com.service.Project.bo.custom;

import com.service.Project.Model.CustomerDto;
import com.service.Project.Model.VechicleDto;
import com.service.Project.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(CustomerDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(CustomerDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
    ArrayList<String> getAllCustIds() throws SQLException, ClassNotFoundException;
    CustomerDto FindById(String id) throws SQLException, ClassNotFoundException;
}
