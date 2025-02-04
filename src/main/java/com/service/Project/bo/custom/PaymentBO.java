package com.service.Project.bo.custom;

import com.service.Project.Model.AllPaymentDto;
import com.service.Project.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    ArrayList<AllPaymentDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(AllPaymentDto dto) throws SQLException, ClassNotFoundException ;
    boolean update(AllPaymentDto dto) throws SQLException, ClassNotFoundException ;
    boolean exist(String id) throws SQLException, ClassNotFoundException ;
    boolean delete(String id) throws SQLException, ClassNotFoundException ;
    String generateID() throws SQLException, ClassNotFoundException ;
}
