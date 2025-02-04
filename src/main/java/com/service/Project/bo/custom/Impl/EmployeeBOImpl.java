package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.CvFormDto;
import com.service.Project.Model.EmployeeDto;
import com.service.Project.bo.custom.EmployeeBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.CvFormDAO;
import com.service.Project.dao.custom.EmployeeDAO;
import com.service.Project.entity.CVForm;
import com.service.Project.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.employee);

    @Override
    public ArrayList<EmployeeDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDto> employeeDtos = new ArrayList<>();
        ArrayList<Employee> employees = employeeDAO.getAll();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto(employee.getEmployeeId(),employee.getEmployeeName(),employee.getDesignation(),employee.getEmail(),employee.getPhoneNumber(),employee.getAdminId());
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public boolean save(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getEmployeeId(),dto.getEmployeeName(),dto.getDesignation(),dto.getEmail(),dto.getPhoneNumber(),dto.getAdminId()));
    }

    @Override
    public boolean update(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       return employeeDAO.delete(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return  employeeDAO.generateID();
    }
}
