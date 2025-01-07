package com.example.sallereservation.service;

import com.example.sallereservation.dao.ReservationDao;
import com.example.sallereservation.model.Reservation;

import java.util.List;

public class ReservationService {
    private ReservationDao reservationDao = new ReservationDao();

    public List<Reservation> getReservationsByUser(int userId) {
        return reservationDao.getReservationsByUser(userId);
    }

    public void saveReservation(Reservation reservation) {
        reservationDao.saveReservation(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        reservationDao.deleteReservation(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationDao.getAllReservations();
    }
}
