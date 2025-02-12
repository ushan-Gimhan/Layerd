package com.service.Project.dao.custom.impl;

import com.service.Project.Model.ParkingLotDto;
import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.ParkingLotDAO;
import com.service.Project.entity.ParkingLot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingLotDAOImpl implements ParkingLotDAO {
    @Override
    public ArrayList<ParkingLot> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.execute("select * from parking_lot");

        ArrayList<ParkingLot> cvFormDtos = new ArrayList<>();

        while (rst.next()) {
            ParkingLot customerDTO = new ParkingLot(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            cvFormDtos.add(customerDTO);
        }
        return cvFormDtos;
    }

    @Override
    public boolean save(ParkingLot parkingLotDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into parking_lot values (?,?,?)",
                parkingLotDto.getLotId(),
                parkingLotDto.getLocation(),
                parkingLotDto.getStatus());
    }

    @Override
    public boolean update(ParkingLot parkingLotDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("update parking_lot set location=?, status=? where lot_id=?",
                parkingLotDto.getLotId(),
                parkingLotDto.getLocation(),
                parkingLotDto.getStatus());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM parking_lot WHERE lot_id=?",id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select lot_id from parking_lot order by lot_id desc limit 1");
        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(2);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("PL%03d", newIdIndex);
        }
        return "PL001";
    }

    @Override
    public ArrayList<String> getAllLotIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select lot_id from parking_lot");

        ArrayList<String> itemIds = new ArrayList<>();

        while (rst.next()) {
            itemIds.add(rst.getString(1));
        }
        return itemIds;
    }
}
