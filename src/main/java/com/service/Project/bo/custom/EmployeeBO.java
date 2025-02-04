package com.service.Project.bo.custom;

import com.service.Project.Model.EmployeeDto;
import com.service.Project.bo.SuperBO;
import com.service.Project.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    ArrayList<EmployeeDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(EmployeeDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(EmployeeDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
}
