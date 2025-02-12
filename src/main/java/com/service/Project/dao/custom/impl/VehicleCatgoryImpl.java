package com.service.Project.dao.custom.impl;

import com.service.Project.Model.VechicleCatagoryDto;
import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.VehicleCtagoryDAO;
import com.service.Project.entity.VCataory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleCatgoryImpl implements VehicleCtagoryDAO {
    @Override
    public ArrayList<VCataory> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from vehicle_category");

        ArrayList<VCataory> vehicleDTOS = new ArrayList<>();

        while (rst.next()) {
            VCataory vehicle = new VCataory(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3)
            );
            vehicleDTOS.add(vehicle);
        }
        return vehicleDTOS;
    }

    @Override
    public boolean save(VCataory dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "insert into vehicle_category values (?,?,?)",dto.getVId(),dto.getVCatagoryName(),dto.getPricePerHoure()
        );
    }

    @Override
    public boolean update(VCataory categoryDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update vehicle_category set category_name=?, price_per_hours=? where category_id=?",
                categoryDTO.getVCatagoryName(),
                categoryDTO.getPricePerHoure(),
                categoryDTO.getVId()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String catId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from vehicle_category where category_id=?", catId);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select category_id from vehicle_category order by category_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1); // Last customer ID
            String substring = lastId.substring(2); // Extract the numeric part
            int i = Integer.parseInt(substring); // Convert the numeric part to integer
            int newIdIndex = i + 1; // Increment the number by 1
            return String.format("VC%03d", newIdIndex); // Return the new customer ID in format Cnnn
        }
        return "VC001";
    }

    @Override
    public ArrayList<String> getAllCatagoryIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("select category_id from vehicle_category");
        ArrayList<String> ids = new ArrayList<>();

        while (result.next()) {
            ids.add(result.getString(1));
        }
        return ids;
    }

    @Override
    public VechicleCatagoryDto findById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from vehicle_category where category_id=?", id);

        if (rst.next()) {
            return new VechicleCatagoryDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3)         );
        }
        return null;
    }
}
