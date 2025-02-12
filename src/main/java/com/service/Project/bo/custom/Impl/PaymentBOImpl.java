package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.PayementDto;
import com.service.Project.Model.AllPaymentDto;
import com.service.Project.bo.custom.PaymentBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.PaymentDAO;
import com.service.Project.entity.AllPayment;
import com.service.Project.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.payment);
    @Override
    public ArrayList<PayementDto> getAll() throws SQLException, ClassNotFoundException {
       return null;
    }

    @Override
    public boolean save(PayementDto dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.save(new Payment(dto.getPayementId(),dto.getPayementAmount(),dto.getPayementDate(),dto.getPayementType(),dto.getCustId()));
    }

    @Override
    public boolean update(PayementDto dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.update(new Payment(dto.getPayementId(),dto.getPayementAmount(),dto.getPayementDate(),dto.getPayementType(),dto.getCustId()));
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return paymentDAO.generateID();
    }

    @Override
    public ArrayList<AllPaymentDto> getAllPayment() throws SQLException, ClassNotFoundException {
        ArrayList<AllPaymentDto> paymentDtos = new ArrayList<>();
        ArrayList<AllPayment> payments = paymentDAO.getAllData();
        for (AllPayment pay : payments) {
            AllPaymentDto employeeDto = new AllPaymentDto(pay.getPaymentId(),pay.getReservationId(),pay.getAmount(),pay.getPaymentDate(),pay.getPaymentMethod(),pay.getCustomerName());
            paymentDtos.add(employeeDto);
        }
        return paymentDtos;
    }
}
