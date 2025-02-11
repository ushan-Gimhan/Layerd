package com.service.Project.bo.custom;

import com.service.Project.Model.AdminDto;
import com.service.Project.Model.CustomerDto;
import com.service.Project.entity.admin;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminBO {
    ArrayList<AdminDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(AdminDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(AdminDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
    ArrayList<String> getAllAdminIds() throws SQLException, ClassNotFoundException;
}
