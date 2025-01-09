package com.example.sallereservation.controller;

import com.example.sallereservation.model.User;
import com.example.sallereservation.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/views/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User user = new User();
        user.setId(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        userService.updateUser(user);

        request.getSession().setAttribute("message", "User updated successfully");
        response.sendRedirect("dashboard");
    }
}
