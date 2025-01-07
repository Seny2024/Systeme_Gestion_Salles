package com.example.sallereservation.dao;

import com.example.sallereservation.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RoomDao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<Room> getAllRooms() {
        Session session = sessionFactory.openSession();
        List<Room> rooms = session.createQuery("from Room", Room.class).list();
        session.close();
        return rooms;
    }

    public void saveRoom(Room room) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(room);
        session.getTransaction().commit();
        session.close();
    }

    public void updateRoom(Room room) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(room);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteRoom(Room room) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(room);
        session.getTransaction().commit();
        session.close();
    }
}
