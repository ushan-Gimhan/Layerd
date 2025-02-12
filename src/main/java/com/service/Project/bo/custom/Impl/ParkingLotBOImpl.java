package com.service.Project.bo.custom.Impl;


import com.service.Project.Model.ParkingLotDto;
import com.service.Project.bo.custom.ParkingLotBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.ParkingLotDAO;
import com.service.Project.entity.ParkingLot;


import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingLotBOImpl implements ParkingLotBO {
    ParkingLotDAO parkingLotDAO = (ParkingLotDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.parkinglot);
    @Override
    public ArrayList<ParkingLotDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ParkingLotDto> LotDtos = new ArrayList<>();
        ArrayList<ParkingLot> lots = parkingLotDAO.getAll();
        for (ParkingLot parkingLot : lots ) {
            ParkingLotDto lotDto = new ParkingLotDto(parkingLot.getLotId(),parkingLot.getLocation(),parkingLot.getStatus());
            LotDtos.add(lotDto);
        }
        return LotDtos;
    }

    @Override
    public boolean save(ParkingLotDto dto) throws SQLException, ClassNotFoundException {
        return parkingLotDAO.save(new ParkingLot(dto.getLotId(),dto.getLocation(),dto.getStatus()));
    }

    @Override
    public boolean update(ParkingLotDto dto) throws SQLException, ClassNotFoundException {
        return parkingLotDAO.save(new ParkingLot(dto.getLotId(),dto.getLocation(),dto.getStatus()));
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
        return parkingLotDAO.generateID();
    }

    @Override
    public ArrayList<String> getAllLotId() throws SQLException, ClassNotFoundException {
        ArrayList<String> lots=parkingLotDAO.getAllLotIds();
        return lots;
    }
}
