package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.EmployeeDto;
import com.service.Project.Model.VechicleCatagoryDto;
import com.service.Project.bo.custom.VCatagoryBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.VehicleCtagoryDAO;
import com.service.Project.entity.VCataory;

import java.sql.SQLException;
import java.util.ArrayList;

public class VCatagoryBOImpl implements VCatagoryBO {
    VehicleCtagoryDAO vcatogry = (VehicleCtagoryDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.vehiclec);
    @Override
    public ArrayList<VechicleCatagoryDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<VechicleCatagoryDto> vehicleDtos = new ArrayList<>();
        ArrayList<VCataory> vehiclecs = vcatogry.getAll();
        for (VCataory catagorys : vehiclecs) {
            VechicleCatagoryDto catagory = new VechicleCatagoryDto(catagorys.getVId(),catagorys.getVCatagoryName(),catagorys.getPricePerHoure());
            vehicleDtos.add(catagory);
        }
        return vehicleDtos;
    }

    @Override
    public boolean save(VechicleCatagoryDto dto) throws SQLException, ClassNotFoundException {
        return vcatogry.save(new VCataory(dto.getVId(),dto.getVCatagoryName(),dto.getPricePerHoure()));
    }

    @Override
    public boolean update(VechicleCatagoryDto dto) throws SQLException, ClassNotFoundException {
        return vcatogry.update(new VCataory(dto.getVId(),dto.getVCatagoryName(),dto.getPricePerHoure()));
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return vcatogry.delete(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return vcatogry.generateID();
    }
}
