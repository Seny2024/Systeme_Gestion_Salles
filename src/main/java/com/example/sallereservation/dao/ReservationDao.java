package com.example.sallereservation.dao;

import com.example.sallereservation.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReservationDao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<Reservation> getReservationsByUser(int userId) {
        Session session = sessionFactory.openSession();
        List<Reservation> reservations = session.createQuery("from Reservation where user.id = :userId", Reservation.class)
                .setParameter("userId", userId)
                .list();
        session.close();
        return reservations;
    }

    public void saveReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(reservation);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(reservation);
        session.getTransaction().commit();
        session.close();
    }

    public List<Reservation> getAllReservations() {
        Session session = sessionFactory.openSession();
        List<Reservation> reservations = session.createQuery("from Reservation", Reservation.class).list();
        session.close();
        return reservations;
    }

    public List<Reservation> getReservationsByRoom(int roomId) {
        Session session = sessionFactory.openSession();
        List<Reservation> reservations = session.createQuery("from Reservation where room.id = :roomId", Reservation.class)
                .setParameter("roomId", roomId)
                .list();
        session.close();
        return reservations;
    }
}
