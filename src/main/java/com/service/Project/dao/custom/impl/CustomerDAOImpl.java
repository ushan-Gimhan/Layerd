package com.service.Project.dao.custom.impl;

import com.service.Project.Model.CvFormDto;
import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.CustomerDAO;
import com.service.Project.dao.custom.CvFormDAO;
import com.service.Project.entity.CVForm;
import com.service.Project.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into customer values (?, ?, ?, ?, ?)",
                dto.getCustomerId(),
                dto.getName(),
                dto.getNIC(),
                dto.getEmail(),
                dto.getPhone()

        );

    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update customer set name=?, NIC=?, email=?, mobile_number=? where cust_id=?",
                dto.getName(),
                dto.getNIC(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getCustomerId()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from customer where cust_id =?",id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select cust_id from customer order by cust_id desc limit 1");
        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("C%03d", newIdIndex);
        }
        return "C001";
    }

    @Override
    public ArrayList<String> getAllCustiIds() throws SQLException, ClassNotFoundException {
        // Execute SQL query to get all item IDs
        ResultSet rst = CrudUtil.execute("select cust_id from customer");

        // Create an ArrayList to store the item IDs
        ArrayList<String> custIds = new ArrayList<>();

        // Iterate through the result set and add each item ID to the list
        while (rst.next()) {
            custIds.add(rst.getString(1));
        }

        // Return the list of item IDs
        return custIds;
    }
}
