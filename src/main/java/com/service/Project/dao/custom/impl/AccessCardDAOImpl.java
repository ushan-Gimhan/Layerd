package com.service.Project.dao.custom.impl;

import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.AccessCardDAO;
import com.service.Project.entity.AccessCard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccessCardDAOImpl implements AccessCardDAO {
    @Override
    public ArrayList<AccessCard> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(AccessCard  accessCardDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into  values(?, ?, ?, ?)",
                accessCardDto.getCardId(),
                accessCardDto.getIssuetDate(),
                accessCardDto.getExpiryDate(),
                accessCardDto.getCustId()
        );
    }

    @Override
    public boolean update(AccessCard  accessCardDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("update access_card set issue_date=?, expiry_date=?, cust_id=? where from card_id=?",
                accessCardDto.getIssuetDate(),
                accessCardDto.getExpiryDate(),
                accessCardDto.getCustId(),
                accessCardDto.getCardId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from access_card where from card_id", id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("select card_id from access_card order by card_id desc limit 1");

        if (resultSet.next()) {
            String lastID = resultSet.getString(1);
            String subString = lastID.substring(1);
            int i = Integer.parseInt(subString);
            int newIndex = i+1;
            return String.format("CD%03d", newIndex);
        }
        return "CD001";
    }
}
