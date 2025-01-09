<%--
  Created by IntelliJ IDEA.
  User: Seny
  Date: 09/01/2025
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Room</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/validation.js"></script>
</head>
<body>
<div class="edit-room-container">
    <h2>Edit Room</h2>
    <form action="editRoom" method="post" onsubmit="return validateRoomForm()">
        <input type="hidden" id="id" name="id" value="${room.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${room.name}" required>
        <label for="capacity">Capacity:</label>
        <input type="number" id="capacity" name="capacity" value="${room.capacity}" required>
        <label for="equipment">Equipment:</label>
        <input type="text" id="equipment" name="equipment" value="${room.equipment}">
        <button type="submit">Update Room</button>
    </form>
    <a href="rooms">Back to Rooms</a>
</div>
</body>
</html>
