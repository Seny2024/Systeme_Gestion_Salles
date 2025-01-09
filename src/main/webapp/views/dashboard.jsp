<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/validation.js"></script>
    <script src="js/modal.js"></script>
</head>
<body>
<div class="dashboard-container">
    <h2>Dashboard</h2>

    <c:if test="${not empty message}">
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                showMessage("${message}");
            });
        </script>
    </c:if>

    <nav>
        <ul>
            <li><a href="rooms">Rooms</a></li>
            <li><a href="reservations">Reservations</a></li>
        </ul>
    </nav>

    <h3>Add User</h3>
    <form action="addUser" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="admin">Admin</option>
            <option value="client">Client</option>
        </select>
        <button type="submit">Add User</button>
    </form>

    <h3>Users List</h3>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td>
                    <a href="editUser?id=${user.id}">Modifier</a>
                    <a href="deleteUser?id=${user.id}">Supprimer</a>
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
