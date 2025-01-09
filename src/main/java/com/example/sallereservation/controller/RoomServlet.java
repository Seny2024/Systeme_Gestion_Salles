package com.example.sallereservation.controller;

import com.example.sallereservation.model.Room;
import com.example.sallereservation.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/rooms")
public class RoomServlet extends HttpServlet {
    private RoomService roomService = new RoomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> rooms = roomService.getAllRooms();
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("/views/rooms.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String equipment = request.getParameter("equipment");

        Room room = new Room();
        room.setName(name);
        room.setCapacity(capacity);
        room.setEquipment(equipment);

        roomService.saveRoom(room);
        request.getSession().setAttribute("message", "Salle ajoutée avec succès !");
        response.sendRedirect("rooms");
    }
}
