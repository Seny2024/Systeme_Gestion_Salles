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
    <title>Salles</title>
    <link rel="stylesheet" type="text/css" href="css/rooms.css">
    <script src="js/validation.js"></script>
    <script src="js/modal.js"></script>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Salles</h2>
    </div>
    <c:if test="${not empty message}">
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                showMessage("${message}");
            });
        </script>
    </c:if>
    <c:choose>
        <c:when test="${user.role eq 'admin'}">
            <form class="reservation-form" action="rooms" method="post" onsubmit="return validateRoomForm()">
                <label for="name">Nom :</label>
                <input type="text" id="name" name="name" required>
                <label for="capacity">Capacité:</label>
                <input type="number" id="capacity" name="capacity" required>
                <label for="equipment">Equipment:</label>
                <input type="text" id="equipment" name="equipment">
                <button type="submit">Ajouter une </button>
            </form>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
    <div class="reservations-list">
        <table>
            <thead>
            <tr>
                <th>Nom</th>
                <th>Capacité</th>
                <th>Equipment</th>
                <c:choose>
                    <c:when test="${user.role eq 'admin'}">
                        <th>Actions</th>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
                    <td>${room.name}</td>
                    <td>${room.capacity}</td>
                    <td>${room.equipment}</td>
                    <c:choose>
                        <c:when test="${user.role eq 'admin'}">
                            <td>
                                <a href="editRoom?id=${room.id}">Modifier</a>
                                <a href="deleteRoom?id=${room.id}">Supprimer</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <footer>
        <a href="dashboard">Retour</a>
        <a href="logout">Se déconnecter</a>
    </footer>
</div>

<!-- Include the message modal -->
<jsp:include page="messageModal.jsp" />
</body>
</html>
