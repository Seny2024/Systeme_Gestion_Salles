<%--
  Created by IntelliJ IDEA.
  User: Seny
  Date: 05/01/2025
  Time: 22:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reservations</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/validation.js"></script>
    <script src="js/modal.js"></script>
</head>
<body>
<div class="reservations-container">
    <p>Total Reservations: ${totalReservations}</p>

    <c:if test="${not empty message}">
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                showMessage("${message}");
            });
        </script>
    </c:if>

    <h2>Faire une réservation</h2>
    <form action="reservations" method="post" onsubmit="return validateReservationForm()">
        <label for="roomId">Room:</label>
        <select id="roomId" name="roomId" required>
            <c:forEach var="room" items="${rooms}">
                <option value="${room.id}">${room.name}</option>
            </c:forEach>
        </select>

        <label for="reservationDate">Reservation Date:</label>
        <input type="date" id="reservationDate" name="reservationDate" required>

        <button type="submit">Réserver</button>
    </form>

    <h2>Reservations List</h2>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>User</th>
            <th>Room</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reservation" items="${reservations}">
            <tr>
                <td>${reservation.id}</td>
                <td>${reservation.user.username}</td>
                <td>${reservation.room.name}</td>
                <td>${reservation.reservationDate}</td>
                <td>
                    <a href="editReservation?id=${reservation.id}">Modifier</a>
                    <a href="deleteReservation?id=${reservation.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="logout">Logout</a>
</div>

<!-- Include message modal -->
<jsp:include page="messageModal.jsp" />

</body>
</html>
