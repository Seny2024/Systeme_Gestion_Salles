<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Réservations</title>
    <link rel="stylesheet" type="text/css" href="css/reservations.css">
    <script src="js/validation.js"></script>
    <script src="js/modal.js"></script>
</head>
<body>
<div class="container">
    <c:if test="${not empty message}">
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                showMessage("${message}");
            });
        </script>
    </c:if>

    <header class="header">
        <h1>Faire une réservation</h1>
    </header>

    <section class="reservation-form">
        <form action="reservations" method="post" onsubmit="return validateReservationForm()">
            <label for="roomId">Salle :</label>
            <select id="roomId" name="roomId" required>
                <c:forEach var="room" items="${rooms}">
                    <option value="${room.id}">${room.name}</option>
                </c:forEach>
            </select>

            <label for="reservationDate">Date de réservation :</label>
            <input type="date" id="reservationDate" name="reservationDate" required>

            <button type="submit">Réserver</button>
        </form>
    </section>

    <section class="reservations-list">
        <h2>Liste des réservations</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Utilisateur</th>
                <th>Salle</th>
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
                        <c:choose>
                            <c:when test="${user.role eq 'admin'}">
                                <a href="editReservation?id=${reservation.id}">Modifier</a>
                                <a href="deleteReservation?id=${reservation.id}">Supprimer</a>
                            </c:when>
                            <c:otherwise>
                                <a href="editReservation?id=${reservation.id}">Modifier</a>
                                <a href="deleteReservation?id=${reservation.id}">Supprimer</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>

    <footer>
        <a href="dashboard">Retour</a>
        <a href="logout">Se déconnecter</a>
    </footer>
</div>

<jsp:include page="messageModal.jsp" />
</body>
</html>
