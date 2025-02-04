package com.service.Project.dao.custom.impl;

import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.StartPageDAO;

import java.sql.ResultSet;

public class StartPageImpl implements StartPageDAO {

    @Override
    public boolean checkValidUser(String name, String password) {
        try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM admin WHERE name = ? AND password = ?", name, password);

            if (rst.next()) {
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
