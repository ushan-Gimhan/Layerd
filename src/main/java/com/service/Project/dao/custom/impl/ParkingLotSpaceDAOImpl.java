package com.service.Project.dao.custom.impl;

import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.ParkingSpaceDAO;
import com.service.Project.entity.Customer;
import com.service.Project.entity.ParkingSpace;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParkingLotSpaceDAOImpl implements ParkingSpaceDAO {

    @Override
    public ArrayList<ParkingSpace> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from parking_space");

        ArrayList<ParkingSpace> cvFormDtos = new ArrayList<>();

        while (rst.next()) {
            ParkingSpace customerDTO = new ParkingSpace(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            cvFormDtos.add(customerDTO);
        }
        return cvFormDtos;
    }

    @Override
    public boolean save(ParkingSpace parkingSpaceDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into parking_space values(?,?,?)",
                parkingSpaceDto.getSpaceId(),
                parkingSpaceDto.getStatus(),
                parkingSpaceDto.getFloorId());
    }

    @Override
    public boolean update(ParkingSpace dto) throws SQLException, ClassNotFoundException {
        return false;
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
        ResultSet rst = CrudUtil.execute("select space_id from parking_space order by space_id desc limit 1");
        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(2);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("PS%03d", newIdIndex);
        }
        return "PS001";
    }
}
