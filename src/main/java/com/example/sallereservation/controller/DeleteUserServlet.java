package com.example.sallereservation.controller;

import com.example.sallereservation.model.User;
import com.example.sallereservation.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loggedUser = (User) request.getSession().getAttribute("user");
        if (loggedUser == null || !loggedUser.getRole().equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/accessDenied");
            return;
        }

        int userId = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(userService.getUserById(userId));

        request.getSession().setAttribute("message", "Utilisateur supprimé avec succès !");
        response.sendRedirect("dashboard");
    }
}
