package com.service.Project.dao.custom;

import com.service.Project.dao.CrudDAO;
import com.service.Project.entity.admin;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminDAO extends CrudDAO<admin> {
    ArrayList<String> getAllAdminIds() throws SQLException, ClassNotFoundException;
}
