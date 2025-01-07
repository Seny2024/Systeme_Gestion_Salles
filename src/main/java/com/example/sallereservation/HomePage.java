
package com.example.sallereservation;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "homePage", value = "/hello-servlet")
public class HomePage extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Rediriger vers index.jsp
        response.sendRedirect("index.jsp");
    }
}

/*
package com.example.sallereservation;

import com.example.sallereservation.dao.ReservationDao;
import com.example.sallereservation.dao.RoomDao;
import com.example.sallereservation.dao.UserDao;
import com.example.sallereservation.model.Reservation;
import com.example.sallereservation.model.Room;
import com.example.sallereservation.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage {

    private static UserDao userDao = new UserDao();
    private static RoomDao roomDao = new RoomDao();
    private static ReservationDao reservationDao = new ReservationDao();

    public static void main(String[] args) {
        // Insérer des exemples de données dans la base de données
        insertSampleData();
    }

    private static void insertSampleData() {
        // Insérer des utilisateurs manuellement
        User admin = insertUser("admin", "admin123", "admin");
        User client = insertUser("client", "client123", "client");

        // Insérer des salles manuellement
        Room room1 = insertRoom("Salle de Réunion 1", 10, "Projecteur, Tableau blanc");
        Room room2 = insertRoom("Salle de Réunion 2", 20, "Projecteur, Tableau blanc, Micro");

        // Insérer des réservations manuellement
        insertReservation(client, room1, "2023-10-01");
        insertReservation(admin, room2, "2023-10-02");
    }

    private static User insertUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userDao.saveUser(user);
        System.out.println("Utilisateur inséré : " + username);
        return user;
    }

    private static Room insertRoom(String name, int capacity, String equipment) {
        Room room = new Room();
        room.setName(name);
        room.setCapacity(capacity);
        room.setEquipment(equipment);
        roomDao.saveRoom(room);
        System.out.println("Salle insérée : " + name);
        return room;
    }

    private static void insertReservation(User user, Room room, String reservationDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date reservationDate = null;
        try {
            reservationDate = dateFormat.parse(reservationDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRoom(room);
        reservation.setReservationDate(reservationDate);
        reservationDao.saveReservation(reservation);
        System.out.println("Réservation insérée : " + user.getUsername() + " a réservé " + room.getName() + " pour le " + reservationDateStr);
    }
}

*/