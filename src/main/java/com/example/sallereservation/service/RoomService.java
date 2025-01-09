package com.example.sallereservation.service;

import com.example.sallereservation.dao.RoomDao;
import com.example.sallereservation.model.Reservation;
import com.example.sallereservation.model.Room;
import com.example.sallereservation.dao.ReservationDao;


import java.util.List;

public class RoomService {
    private RoomDao roomDao = new RoomDao();
    private ReservationDao reservationDao = new ReservationDao();

    public List<Room> getAllRooms() {
        return roomDao.getAllRooms();
    }

    public void saveRoom(Room room) {
        roomDao.saveRoom(room);
    }

    public Room getRoomById(int roomId) {
        return roomDao.getRoomById(roomId);
    }

    public void deleteRoom(int roomId) {
        // Vérifiez si la salle a des réservations associées
        List<Reservation> reservations = reservationDao.getReservationsByRoom(roomId);
        if (!reservations.isEmpty()) {
            throw new IllegalArgumentException("Cannot delete room with existing reservations.");
        }
        roomDao.deleteRoom(roomId);
    }

    public void updateRoom(Room room) {
        roomDao.updateRoom(room);
    }
}
