package com.service.Project.dao.custom;

import com.service.Project.dao.CrudDAO;
import com.service.Project.entity.AllPayment;
import com.service.Project.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentDAO extends CrudDAO<Payment> {
    public ArrayList<AllPayment> getAllData() throws SQLException, ClassNotFoundException;
}
