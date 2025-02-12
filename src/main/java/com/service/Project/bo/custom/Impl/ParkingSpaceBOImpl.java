package com.service.Project.bo.custom.Impl;


import com.service.Project.Model.ParkingSpaceDto;
import com.service.Project.bo.custom.ParkingSpaceBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.ParkingSpaceDAO;
import com.service.Project.entity.ParkingSpace;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingSpaceBOImpl implements ParkingSpaceBO {
    ParkingSpaceDAO parkingSpace = (ParkingSpaceDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.space);

    @Override
    public ArrayList<ParkingSpaceDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ParkingSpaceDto> Spases = new ArrayList<>();
        ArrayList<ParkingSpace> spaces = parkingSpace.getAll();
        for (ParkingSpace space : spaces) {
            ParkingSpaceDto spaceDto = new ParkingSpaceDto(space.getSpaceId(),space.getStatus(),space.getFloorId());
            Spases.add(spaceDto);
        }
        return Spases;
    }

    @Override
    public boolean save(ParkingSpaceDto dto) throws SQLException, ClassNotFoundException {
        return parkingSpace.save(new ParkingSpace(dto.getSpaceId(),dto.getFloorId(),dto.getStatus()));
    }

    @Override
    public boolean update(ParkingSpaceDto dto) throws SQLException, ClassNotFoundException {
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
        return parkingSpace.generateID();
    }

    @Override
    public ArrayList<String> getAllFloorIds() throws SQLException, ClassNotFoundException {
        return parkingSpace.getAllIds();
    }
}
