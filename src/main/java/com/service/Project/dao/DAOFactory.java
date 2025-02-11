package com.service.Project.dao;

import com.service.Project.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public static DAOFactory setDaoFactory() {
        if(daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOType{
        customer,employee,payment,vehiclec,vehicle,admin,parkinglot,floor,space,accescard;
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
            case vehicle:
                return new VehicleDAOImpl();
            case admin:
                return new AdminDAOImpl();
            case parkinglot:
                return new ParkingLotDAOImpl();
            case floor:
                return new FloorDAOImpl();
            case space:
                return new ParkingLotSpaceDAOImpl();
            case accescard:
                return new AccessCardDAOImpl();
            default:
                return null;
        }
    }
}
