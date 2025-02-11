package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.EmployeeDto;
import com.service.Project.Model.FloorDto;
import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.bo.custom.FloorBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.FloorIdDAO;
import com.service.Project.entity.Employee;
import com.service.Project.entity.Floor;

import java.sql.SQLException;
import java.util.ArrayList;

public class FloorBOImpl implements FloorBO {
    FloorIdDAO floorIdDAO = (FloorIdDAO)DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.floor);
    @Override
    public ArrayList<FloorDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<FloorDto> floorDtos = new ArrayList<>();
        ArrayList<Floor> floors = floorIdDAO.getAll();
        for (Floor floor : floors) {
           FloorDto floordto = new FloorDto(floor.getFloorId(),floor.getLotId(),floor.getStatus());
            floorDtos.add(floordto);
        }
        return floorDtos;
    }

    @Override
    public boolean save(FloorDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(FloorDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return floorIdDAO.generateID();
    }

    @Override
    public CvFromTm search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
