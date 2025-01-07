package com.example.sallereservation.controller;

import com.example.sallereservation.model.User;
import com.example.sallereservation.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        userService.saveUser(user);

        response.sendRedirect("dashboard");
    }
}
