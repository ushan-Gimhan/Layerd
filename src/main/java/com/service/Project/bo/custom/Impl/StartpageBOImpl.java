package com.service.Project.bo.custom.Impl;

import com.service.Project.bo.custom.loginPageBO;
import com.service.Project.dao.custom.StartPageDAO;
import com.service.Project.dao.custom.impl.StartPageImpl;

public class StartpageBOImpl implements loginPageBO {

    StartPageDAO startPageDAO = new StartPageImpl();

    @Override
    public boolean checkUserName(String userName, String password) {
        return startPageDAO.checkValidUser(userName, password);
    }
}
