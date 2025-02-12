package com.service.Project.dao.custom;

import com.service.Project.Model.VechicleCatagoryDto;
import com.service.Project.dao.CrudDAO;
import com.service.Project.dao.SuperDAO;
import com.service.Project.entity.VCataory;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleCtagoryDAO extends CrudDAO<VCataory> {
    ArrayList<String> getAllCatagoryIds() throws SQLException, ClassNotFoundException;
    VechicleCatagoryDto findById(String id) throws SQLException, ClassNotFoundException;
}
