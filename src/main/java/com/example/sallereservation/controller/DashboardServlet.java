package com.example.sallereservation.controller;

import com.example.sallereservation.model.Reservation;
import com.example.sallereservation.model.User;
import com.example.sallereservation.service.ReservationService;
import com.example.sallereservation.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private ReservationService reservationService = new ReservationService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vérifiez si l'utilisateur est connecté
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Supposons que l'admin peut voir toutes les réservations
        List<Reservation> reservations = reservationService.getAllReservations();
        List<User> users = userService.getAllUsers();

        request.setAttribute("reservations", reservations);
        request.setAttribute("totalReservations", reservations.size());
        request.setAttribute("users", users);

        request.getRequestDispatcher("/views/dashboard.jsp").forward(request, response);
    }
    
}
