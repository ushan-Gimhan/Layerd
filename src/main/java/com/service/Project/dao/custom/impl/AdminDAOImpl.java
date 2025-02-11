package com.service.Project.dao.custom.impl;

import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.AdminDAO;
import com.service.Project.entity.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public ArrayList<String> getAllAdminIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select admin_id from admin");

        // Create an ArrayList to store the item IDs
        ArrayList<String> adminIds = new ArrayList<>();

        // Iterate through the result set and add each item ID to the list
        while (rst.next()) {
            adminIds.add(rst.getString(1));
        }

        // Return the list of item IDs
        return adminIds;
    }

    @Override
    public ArrayList<admin> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(admin dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(admin dto) throws SQLException, ClassNotFoundException {
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
