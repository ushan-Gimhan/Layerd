package com.service.Project.dao;

import com.service.Project.dao.custom.impl.CVFormImpl;
import com.service.Project.dao.custom.impl.EmployeeDAOImpl;
import com.service.Project.dao.custom.impl.PaymentDAOImpl;
import com.service.Project.dao.custom.impl.VehicleCatgoryImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public static DAOFactory setDaoFactory() {
        if(daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOType{
        customer,employee,payment,vehiclec;
    }
    public SuperDAO getDao(DAOType type){
        switch (type){
            case customer:
                return new CVFormImpl();
            case employee:
                return new EmployeeDAOImpl();
            case payment:
                return new PaymentDAOImpl();
                case vehiclec:
                    return new VehicleCatgoryImpl();
                default:
                    return null;
        }
    }
}
