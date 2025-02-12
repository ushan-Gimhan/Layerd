package com.service.Project.dao.custom.impl;

import com.service.Project.Model.AllPaymentDto;
import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.PaymentDAO;
import com.service.Project.entity.AllPayment;
import com.service.Project.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean save(Payment paydto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into payment (?,?,?,?,?)",
                paydto.getPayementId(),
                paydto.getPayementAmount(),
                paydto.getPayementDate(),
                paydto.getPayementType(),
                paydto.getCustId());
    }

    @Override
    public boolean update(Payment paydto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE payment SET payementAmount = ?, payementDate = ?, payementType = ?, custId = ? WHERE payementId = ?",
                paydto.getPayementAmount(),
                paydto.getPayementDate(),
                paydto.getPayementType(),
                paydto.getCustId(),
                paydto.getPayementId());

    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM payment WHERE payementId = ?",id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select payment_id  from payment order by payment_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("P%03d", newIdIndex);
        }
        return "P001";
    }

    @Override
    public ArrayList<AllPayment> getAllData() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute(
                "SELECT payment.payment_id,reservation.res_id,payment.amount,payment.payment_date,payment.method, customer.name FROM reservation JOIN customer ON reservation.cust_id = customer.cust_id JOIN payment ON payment.cust_id = customer.cust_id"
        );

        ArrayList<AllPayment> paymentDtos = new ArrayList<>();

        while (rst.next()) {
            AllPayment paymentDto = new AllPayment(
                    rst.getString(1), // Payment ID
                    rst.getString(2), // Reservation ID
                    rst.getDouble(3), // Amount
                    rst.getString(4), // Payment Date
                    rst.getString(5), // Payment Method
                    rst.getString(6)  // Customer Name
            );
            paymentDtos.add(paymentDto);
        }

        return paymentDtos;
    }
}
