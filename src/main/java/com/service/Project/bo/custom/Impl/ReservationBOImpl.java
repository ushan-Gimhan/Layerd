package com.service.Project.bo.custom.Impl;

import com.service.Project.Model.AllPaymentDto;
import com.service.Project.Model.ResavationDto;
import com.service.Project.Model.Reservationdto;
import com.service.Project.bo.custom.ReservationBO;
import com.service.Project.dao.DAOFactory;
import com.service.Project.dao.custom.ReservationDAO;
import com.service.Project.entity.AllPayment;
import com.service.Project.entity.AllReservation;
import com.service.Project.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.setDaoFactory().getDao(DAOFactory.DAOType.reservation);
    @Override
    public ArrayList<ResavationDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ResavationDto dto) throws SQLException, ClassNotFoundException {
       return reservationDAO.save(new Reservation(dto.getResId(),dto.getStartTime(),dto.getEndTime(),dto.getCustId(),dto.getSpaceId(),dto.getResDate(),dto.getEndDate(),dto.getPrice()));
    }

    @Override
    public boolean update(ResavationDto dto) throws SQLException, ClassNotFoundException {
        return reservationDAO.update(new Reservation(dto.getResId(),dto.getStartTime(),dto.getEndTime(),dto.getCustId(),dto.getSpaceId(),dto.getResDate(),dto.getEndDate(),dto.getPrice()));
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return reservationDAO.delete(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return reservationDAO.generateID();
    }

    @Override
    public ArrayList<Reservationdto> getAllData() throws SQLException, ClassNotFoundException {
        ArrayList<Reservationdto> reservationDtos = new ArrayList<>();
        ArrayList<AllReservation> reservations = reservationDAO.getAllTableData();
        for (AllReservation reservation : reservations) {
            Reservationdto reservationdto = new Reservationdto(reservation.getReservationId(),reservation.getCustomerId(),reservation.getLotId(),reservation.getFloorId(),reservation.getSpaceId(),reservation.getReservationDate(),reservation.getEndDate(),reservation.getStartTime(),reservation.getEndTime(),reservation.getCustomerName(),reservation.getAmount());
            reservationDtos.add(reservationdto);
        }
        return reservationDtos;
    }
}
