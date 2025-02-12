package com.service.Project.dao.custom.impl;

import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.FloorIdDAO;
import com.service.Project.entity.Floor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FloorDAOImpl implements FloorIdDAO {
    @Override
    public ArrayList<Floor> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from floor");

        ArrayList<Floor> cvFormDtos = new ArrayList<>();

        while (rst.next()) {
            Floor customerDTO = new Floor(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            cvFormDtos.add(customerDTO);
        }
        return cvFormDtos;
    }

    @Override
    public boolean save(Floor floorDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into floor values (?,?,?)",
                floorDto.getFloorId(),
                floorDto.getLotId(),
                floorDto.getStatus()
        );
    }

    @Override
    public boolean update(Floor dto) throws SQLException, ClassNotFoundException {
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
        ResultSet rst = CrudUtil.execute("select floor_id from floor order by floor_id desc limit 1");
        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("F%03d", newIdIndex);
        }
        return "F001";
    }

    @Override
    public ArrayList<String> getFloors() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select floor_id from floor");

        // Create an ArrayList to store the item IDs
        ArrayList<String> itemIds = new ArrayList<>();

        // Iterate through the result set and add each item ID to the list
        while (rst.next()) {
            itemIds.add(rst.getString(1));
        }

        // Return the list of item IDs
        return itemIds;
    }
}
