package com.example.sallereservation.controller;

import com.example.sallereservation.model.Reservation;
import com.example.sallereservation.model.Room;
import com.example.sallereservation.model.User;
import com.example.sallereservation.service.ReservationService;
import com.example.sallereservation.service.RoomService;
import com.example.sallereservation.service.UserService;

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

@WebServlet("/editReservation")
public class EditReservationServlet extends HttpServlet {
    private ReservationService reservationService = new ReservationService();
    private RoomService roomService = new RoomService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("id"));
        Reservation reservation = reservationService.getReservationById(reservationId);
        List<Room> rooms = roomService.getAllRooms();

        request.setAttribute("reservation", reservation);
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("/views/editReservation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reservationId = Integer.parseInt(request.getParameter("id"));
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String reservationDateStr = request.getParameter("reservationDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date reservationDate = null;
        try {
            reservationDate = dateFormat.parse(reservationDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Reservation reservation = reservationService.getReservationById(reservationId);
        reservation.setRoom(roomService.getRoomById(roomId));
        reservation.setReservationDate(reservationDate);

        // Assurez-vous que l'utilisateur est correctement défini
        User user = (User) request.getSession().getAttribute("user");
        reservation.setUser(userService.getUserByUsername(user.getUsername()));

        reservationService.updateReservation(reservation);

        request.getSession().setAttribute("message", "Reservation modifiée avec succès !");
        response.sendRedirect("reservations");
    }
}
