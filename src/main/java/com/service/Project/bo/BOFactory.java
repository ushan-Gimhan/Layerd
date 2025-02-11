package com.service.Project.bo;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=
                new BOFactory():boFactory;

    }
    public enum BOTypes{
        AccesCard
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case AccesCard:
                return new CustomerBOImpl();
            default:
                return null;
        }
    }
}
