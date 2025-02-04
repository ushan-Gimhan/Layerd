package com.service.Project.dao.custom;

import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.dao.CrudDAO;
import com.service.Project.entity.CVForm;
import com.service.Project.entity.Customer;

import java.sql.SQLException;

public interface CvFormDAO extends CrudDAO<CVForm> {
    //Customers unique methods
    public CvFromTm search(String id) throws SQLException, ClassNotFoundException;

}
