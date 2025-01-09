package com.example.sallereservation.controller;

import com.example.sallereservation.model.Room;
import com.example.sallereservation.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editRoom")
public class EditRoomServlet extends HttpServlet {
    private RoomService roomService = new RoomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomId = Integer.parseInt(request.getParameter("id"));
        Room room = roomService.getRoomById(roomId);
        request.setAttribute("room", room);
        request.getRequestDispatcher("/views/editRoom.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String equipment = request.getParameter("equipment");

        Room room = new Room();
        room.setId(roomId);
        room.setName(name);
        room.setCapacity(capacity);
        room.setEquipment(equipment);

        roomService.updateRoom(room);
        request.getSession().setAttribute("message", "Room updated successfully.");
        response.sendRedirect("rooms");
    }
}
