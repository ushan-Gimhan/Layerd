package com.service.Project.bo.custom.Impl;


import com.service.Project.Model.CvFormDto;
import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.bo.custom.CVFormBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.CvFormDAO;
import com.service.Project.entity.CVForm;


import java.sql.SQLException;
import java.util.ArrayList;

public class CVFormBOImpl implements CVFormBO {
    CvFormDAO cvFormDAO = (CvFormDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.customer);
    @Override
    public ArrayList<CvFormDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CvFormDto> cvFormDtos = new ArrayList<>();
        ArrayList<CVForm> cvForms = cvFormDAO.getAll();
        for (CVForm cvForm : cvForms) {
            CvFormDto cvFormDto = new CvFormDto(cvForm.getCustomerId(),cvForm.getName(),cvForm.getNIC(),cvForm.getEmail(),cvForm.getPhone(),cvForm.getVehicleNumber(),cvForm.getVehicleCategory(),cvForm.getPricePerHourse());
            cvFormDtos.add(cvFormDto);
        }
        return cvFormDtos;
    }

    @Override
    public boolean save(CvFormDto dto) throws SQLException, ClassNotFoundException {
        return cvFormDAO.save(new CVForm(dto.getCustomerId(), dto.getName(), dto.getNIC(), dto.getEmail(), dto.getPhone(), dto.getVehicleNumber(), dto.getVehicleCategory(), dto.getPricePerHourse()));
    }
    @Override
    public boolean update(CvFormDto dto) throws SQLException, ClassNotFoundException {
        return cvFormDAO.update(new CVForm(dto.getCustomerId(), dto.getName(), dto.getNIC(), dto.getEmail(), dto.getPhone(), dto.getVehicleNumber(), dto.getVehicleCategory(), dto.getPricePerHourse()));
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        cvFormDAO.delete(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return cvFormDAO.generateID();
    }

    @Override
    public CvFromTm search(String id) throws SQLException, ClassNotFoundException {
        return cvFormDAO.search(id);
    }
}
