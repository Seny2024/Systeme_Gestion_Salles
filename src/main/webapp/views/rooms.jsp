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
    <title>Rooms</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/validation.js"></script>
    <script src="js/modal.js"></script>
</head>
<body>
<div class="rooms-container">
    <h2>Rooms</h2>
    <c:if test="${not empty message}">
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                showMessage("${message}");
            });
        </script>
    </c:if>
    <form action="rooms" method="post" onsubmit="return validateRoomForm()">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <label for="capacity">Capacity:</label>
        <input type="number" id="capacity" name="capacity" required>
        <label for="equipment">Equipment:</label>
        <input type="text" id="equipment" name="equipment">
        <button type="submit">Add Room</button>
    </form>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Capacity</th>
            <th>Equipment</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td>${room.name}</td>
                <td>${room.capacity}</td>
                <td>${room.equipment}</td>
                <td>
                    <a href="editRoom?id=${room.id}">Edit</a>
                    <a href="deleteRoom?id=${room.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="logout">Logout</a>
</div>

<!-- Include the message modal -->
<jsp:include page="messageModal.jsp" />

</body>
</html>
