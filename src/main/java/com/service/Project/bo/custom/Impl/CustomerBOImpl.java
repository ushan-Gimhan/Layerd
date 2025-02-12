package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.CustomerDto;
import com.service.Project.bo.custom.CustomerBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.CustomerDAO;
import com.service.Project.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerBO =(CustomerDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.customer);
    @Override
    public ArrayList<CustomerDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerBO.save(new Customer(dto.getCustomerId(),dto.getName(),dto.getNIC(),dto.getEmail(), dto.getPhone()));
    }

    @Override
    public boolean update(CustomerDto dto) throws SQLException, ClassNotFoundException {
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

    @Override
    public ArrayList<String> getAllCustIds() throws SQLException, ClassNotFoundException {
        return customerBO.getAllCustiIds();
    }
}
