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
    <c:if test="${not empty message}">
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                showMessage("${message}");
            });
        </script>
    </c:if>

    <h1>Bienvenue sur le tableau de bord !</h1>

    <div class="container">
        <button onclick="window.location.href='rooms'">Voir les salles</button>
        <button onclick="window.location.href='reservations'">Gérer les réservations</button>
        <button onclick="window.location.href='logout'">Se déconnecter</button>
    </div>

    <c:choose>
        <c:when test="${user.role eq 'admin'}">
            <h3>Add User</h3>
            <form action="addUser" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <label for="role">Role:</label>
                <select id="role" name="role" required>
                    <option value="admin">admin</option>
                    <option value="client">user</option>
                </select>
                <button type="submit">Ajouter un utilisateur</button>
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
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>

</div>

<!-- Include message modal -->
<jsp:include page="messageModal.jsp" />

</body>
</html>
