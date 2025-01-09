package com.example.sallereservation.controller;

import com.example.sallereservation.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteRoom")
public class DeleteRoomServlet extends HttpServlet {
    private RoomService roomService = new RoomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomId = Integer.parseInt(request.getParameter("id"));
        try {
            roomService.deleteRoom(roomId);
            request.getSession().setAttribute("message", "Room deleted successfully.");
        } catch (IllegalArgumentException e) {
            request.getSession().setAttribute("message", e.getMessage());
        }
        response.sendRedirect("rooms");
    }
}
