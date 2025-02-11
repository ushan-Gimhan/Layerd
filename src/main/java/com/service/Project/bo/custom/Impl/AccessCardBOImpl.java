package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.AccessCardDto;
import com.service.Project.bo.custom.AccesCardBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.AccessCardDAO;
import com.service.Project.dao.custom.impl.AccessCardDAOImpl;
import com.service.Project.entity.AccessCard;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccessCardBOImpl implements AccesCardBO {
    AccessCardDAO accessCardDAO = (AccessCardDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.accescard);
    @Override
    public ArrayList<AccessCardDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(AccessCardDto dto) throws SQLException, ClassNotFoundException {
        return accessCardDAO.save(new AccessCard(dto.getCardId(),dto.getIssuetDate(),dto.getExpiryDate(),dto.getCustId()));
    }

    @Override
    public boolean update(AccessCardDto dto) throws SQLException, ClassNotFoundException {
        return accessCardDAO.update(new AccessCard(dto.getCardId(),dto.getIssuetDate(),dto.getExpiryDate(),dto.getCustId()));
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return accessCardDAO.delete(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return accessCardDAO.generateID();
    }
}
