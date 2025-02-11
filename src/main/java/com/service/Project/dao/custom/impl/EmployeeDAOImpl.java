package com.service.Project.dao.custom.impl;

import com.service.Project.dao.CrudUtil;
import com.service.Project.dao.custom.EmployeeDAO;
import com.service.Project.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from employee");

        ArrayList<Employee> employeeDtos = new ArrayList<>();

        while (rst.next()) {
            Employee employeeDto = new Employee(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5) ,
                    rst.getString(6)
            );
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public boolean save(Employee employeeDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "insert into employee values (?,?,?,?,?,?)",
                employeeDto.getEmployeeId(),
                employeeDto.getEmployeeName(),
                employeeDto.getDesignation(),
                employeeDto.getEmail(),
                employeeDto.getPhoneNumber(),
                employeeDto.getAdminId()
        );
    }

    @Override
    public boolean update(Employee employeeDto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update employee set name=?, designation=?, email=?, mobile_number=?,admin_id=? where emp_id=?",
                employeeDto.getEmployeeName(),
                employeeDto.getDesignation(),
                employeeDto.getEmail(),
                employeeDto.getPhoneNumber(),
                employeeDto.getAdminId(),
                employeeDto.getEmployeeId()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
         return CrudUtil.execute("delete from employee where emp_id=?", id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select emp_id from employee order by emp_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("E%03d", newIdIndex);
        }
        return "E001";
    }
}
