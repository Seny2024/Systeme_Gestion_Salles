package com.example.sallereservation.service;

import com.example.sallereservation.dao.RoomDao;
import com.example.sallereservation.model.Room;

import java.util.List;

public class RoomService {
    private RoomDao roomDao = new RoomDao();

    public List<Room> getAllRooms() {
        return roomDao.getAllRooms();
    }

    public void saveRoom(Room room) {
        roomDao.saveRoom(room);
    }

    public Room getRoomById(int roomId) {
        return roomDao.getRoomById(roomId);
    }
}
