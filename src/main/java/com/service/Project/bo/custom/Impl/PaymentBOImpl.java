package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.AllPaymentDto;
import com.service.Project.Model.EmployeeDto;
import com.service.Project.bo.custom.PaymentBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.EmployeeDAO;
import com.service.Project.dao.custom.PaymentDAO;
import com.service.Project.dao.custom.impl.PaymentDAOImpl;
import com.service.Project.entity.AllPayment;
import com.service.Project.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.payment);
    @Override
    public ArrayList<AllPaymentDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<AllPaymentDto> paymentDtos = new ArrayList<>();
        ArrayList<AllPayment> payments = paymentDAO.getAllData();
        for (AllPayment pay : payments) {
            AllPaymentDto employeeDto = new AllPaymentDto(pay.getPaymentId(),pay.getReservationId(),pay.getAmount(),pay.getPaymentDate(),pay.getPaymentMethod(),pay.getCustomerName());
            paymentDtos.add(employeeDto);
        }
        return paymentDtos;
    }

    @Override
    public boolean save(AllPaymentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(AllPaymentDto dto) throws SQLException, ClassNotFoundException {
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
        return "";
    }
}
