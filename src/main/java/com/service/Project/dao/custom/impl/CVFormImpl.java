package com.service.Project.dao.custom.impl;

import com.service.Project.View.Tm.CvFromTm;
import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.CvFormDAO;
import com.service.Project.entity.CVForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CVFormImpl implements CvFormDAO{
    @Override
    public ArrayList<CVForm> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT customer.cust_id,customer.name,customer.NIC,customer.email,customer.mobile_number,vehicle.license_plate,vehicle_category.category_id,vehicle_category.price_per_hours FROM customer JOIN vehicle ON customer.cust_id = vehicle.cust_id JOIN vehicle_category ON vehicle.category_id = vehicle_category.category_id");

        ArrayList<CVForm> cvFormDtos = new ArrayList<>();

        while (rst.next()) {
            CVForm customerDTO = new CVForm(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getDouble(8)
            );
            cvFormDtos.add(customerDTO);
        }
        return cvFormDtos;
    }

    @Override
    public boolean save(CVForm dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into customer values (?, ?, ?, ?, ?)",
                dto.getCustomerId(),
                dto.getName(),
                dto.getNIC(),
                dto.getEmail(),
                dto.getPhone()

        );
    }

    @Override
    public boolean update(CVForm dto) throws SQLException, ClassNotFoundException {
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
    public CvFromTm search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from customer where cust_id=?",id);

        if (rst.next()) {
            return new CvFromTm(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getDouble(8));

        }
        return null;
    }

}
