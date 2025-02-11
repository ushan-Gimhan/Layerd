package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.VechicleDto;
import com.service.Project.bo.custom.VehicleBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.VehicleDAO;
import com.service.Project.dao.custom.impl.VehicleDAOImpl;
import com.service.Project.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBOImpl implements VehicleBO {
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.vehicle);
    @Override
    public ArrayList<VechicleDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(VechicleDto dto) throws SQLException, ClassNotFoundException {
        return vehicleDAO.save(new Vehicle(dto.getVId(),dto.getVLisenPlate(),dto.getCId(),dto.getCatagoryId()));
    }

    @Override
    public boolean update(VechicleDto dto) throws SQLException, ClassNotFoundException {
        return vehicleDAO.update(new Vehicle(dto.getVId(),dto.getVLisenPlate(),dto.getCId(),dto.getCatagoryId()));
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return vehicleDAO.delete(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return vehicleDAO.generateID();
    }
}
