<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Edit Reservation</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <script src="js/validation.js"></script>
</head>
<body>
<div class="reservations-container">
  <h2>Modifier la réservation</h2>
  <form action="editReservation" method="post" onsubmit="return validateReservationForm()">
    <input type="hidden" name="id" value="${reservation.id}">
    <label for="roomId">Slle:</label>
    <select id="roomId" name="roomId" required>
      <c:forEach var="room" items="${rooms}">
        <option value="${room.id}" ${room.id == reservation.room.id ? 'selected' : ''}>${room.name}</option>
      </c:forEach>
    </select>

    <label for="reservationDate">Date de reservation:</label>
    <input type="date" id="reservationDate" name="reservationDate" value="${reservation.reservationDate}" required>

    <button type="submit">Mettre à jour</button>
  </form>

  <a href="reservations">Retour</a>
</div>
</body>
</html>
