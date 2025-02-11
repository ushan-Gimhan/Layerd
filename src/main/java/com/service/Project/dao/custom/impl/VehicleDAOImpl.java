package com.service.Project.dao.custom.impl;

import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.VehicleDAO;
import com.service.Project.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public ArrayList<Vehicle> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Vehicle vechicleDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into vehicle values (?, ?, ?, ?)",
                vechicleDto.getVId(),
                vechicleDto.getVLisenPlate(),
                vechicleDto.getCId(),
                vechicleDto.getCatagoryId());
    }

    @Override
    public boolean update(Vehicle vechicleDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("update vehicle set license_plate=?,cust_id=?,category_id =?  where vehicle_id=?",
                vechicleDto.getVLisenPlate(),
                vechicleDto.getCId(),
                vechicleDto.getCatagoryId(),
                vechicleDto.getVId()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from vehicle where vehicle_id =? ",id);

    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select vehicle_id from vehicle order by vehicle_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("V%03d", newIdIndex);
        }
        return "V001";
    }
}
