package com.service.Project.dao.custom;

import com.service.Project.dao.CrudDAO;
import com.service.Project.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {
    ArrayList<String> getAllCustiIds() throws SQLException, ClassNotFoundException;
}
