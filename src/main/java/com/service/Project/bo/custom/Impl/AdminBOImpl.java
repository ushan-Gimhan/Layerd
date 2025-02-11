package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.AdminDto;
import com.service.Project.bo.custom.AdminBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.AdminDAO;
import com.service.Project.entity.admin;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminBOImpl implements AdminBO {
    AdminDAO adminBO = (AdminDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.admin);
    @Override
    public ArrayList<AdminDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(AdminDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(AdminDto dto) throws SQLException, ClassNotFoundException {
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
    public ArrayList<String> getAllAdminIds() throws SQLException, ClassNotFoundException {
        return adminBO.getAllAdminIds();
    }
}
