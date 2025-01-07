package com.example.sallereservation.controller;

import com.example.sallereservation.model.Reservation;
import com.example.sallereservation.model.Room;
import com.example.sallereservation.model.User;
import com.example.sallereservation.service.ReservationService;
import com.example.sallereservation.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@WebServlet("/reservations")
public class ReservationServlet extends HttpServlet {
    private ReservationService reservationService = new ReservationService();
    private RoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vérifiez si l'utilisateur est connecté
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Récupérez toutes les réservations et toutes les salles
        List<Reservation> reservations = reservationService.getAllReservations();
        List<Room> rooms = roomService.getAllRooms();

        request.setAttribute("reservations", reservations);
        request.setAttribute("totalReservations", reservations.size());
        request.setAttribute("rooms", rooms);

        request.getRequestDispatcher("/views/reservations.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String reservationDateStr = request.getParameter("reservationDate");
        User user = (User) request.getSession().getAttribute("user");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date reservationDate = null;
        try {
            reservationDate = dateFormat.parse(reservationDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Room room = roomService.getRoomById(roomId);
        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setUser(user);
        reservation.setReservationDate(reservationDate);

        reservationService.saveReservation(reservation);
        response.sendRedirect("reservations");
    }
}
