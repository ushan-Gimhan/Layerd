package com.service.Project.dao.custom.impl;

import com.service.Project.Model.CvFormDto;
import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.CustomerDAO;
import com.service.Project.dao.custom.CvFormDAO;
import com.service.Project.entity.CVForm;
import com.service.Project.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return "";
    }
}
