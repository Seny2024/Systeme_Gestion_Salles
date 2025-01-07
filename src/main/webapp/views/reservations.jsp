<%--
  Created by IntelliJ IDEA.
  User: Seny
  Date: 05/01/2025
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reservations</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="reservations-container">
    <h2>Reservations</h2>
    <form action="reservations" method="post" onsubmit="return validateReservationForm()">
        <label for="roomId">Room:</label>
        <select id="roomId" name="roomId" required>
            <c:forEach var="room" items="${rooms}">
                <option value="${room.id}">${room.name}</option>
            </c:forEach>
        </select>
        <label for="reservationDate">Reservation Date:</label>
        <input type="date" id="reservationDate" name="reservationDate" required>
        <button type="submit">Make Reservation</button>
    </form>
    <table>
        <tr>
            <th>Room</th>
            <th>Reservation Date</th>
        </tr>
        <c:forEach var="reservation" items="${reservations}">
            <tr>
                <td>${reservation.room.name}</td>
                <td>${reservation.reservationDate}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="logout">Logout</a>
</div>
</body>
</html>
