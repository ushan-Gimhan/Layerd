package com.service.Project.bo;

import com.service.Project.bo.custom.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=
                new BOFactory():boFactory;

    }
    public enum BOTypes{
        AccesCard,customer,vehicle,payment,reservation,vcatagory,cvform,employee,admin,floor,lot,space
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case AccesCard:
                return new AccessCardBOImpl();
            case customer:
                return new CustomerBOImpl();
            case vehicle:
                return new VehicleBOImpl();
            case payment:
                return new PaymentBOImpl();
            case reservation:
                return new ReservationBOImpl();
            case vcatagory:
                return new VCatagoryBOImpl();
            case cvform:
                return new CVFormBOImpl();
            case employee:
                return new EmployeeBOImpl();
            case admin:
                return new AdminBOImpl();
            case floor:
                return new FloorBOImpl();
            case lot:
                return new ParkingLotBOImpl();
            case space:
                return new ParkingSpaceBOImpl();
            default:
                return null;
        }
    }
}
