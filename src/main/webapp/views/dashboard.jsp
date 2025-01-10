<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Tableau de bord</title>
    <link rel="stylesheet" type="text/css" href="css/dashboard.css">
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

    <header class="dashboard-header">
        <h1>Bienvenue sur le tableau de bord</h1>
    </header>

    <nav class="dashboard-navigation">
        <button onclick="window.location.href='rooms'">Voir les salles</button>
        <button onclick="window.location.href='reservations'">Gérer les réservations</button>
        <button onclick="window.location.href='logout'">Se déconnecter</button>
    </nav>

    <main class="dashboard-main">
        <c:choose>
            <c:when test="${user.role eq 'admin'}">
                <section class="admin-section">
                    <h2>Ajouter un utilisateur</h2>
                    <form class="custom-form" action="addUser" method="post">
                        <label for="username">Nom d'utilisateur :</label>
                        <input type="text" id="username" name="username" required>
                        <label for="password">Mot de passe :</label>
                        <input type="password" id="password" name="password" required>
                        <label for="role">Rôle :</label>
                        <select id="role" name="role" required>
                            <option value="admin">admin</option>
                            <option value="user">user</option>
                        </select>
                        <button type="submit">Ajouter un utilisateur</button>
                    </form>

                    <h2>Liste des utilisateurs</h2>
                    <table class="user-table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Rôle</th>
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
                                    <a href="editUser?id=${user.id}" class="action-link">Modifier</a>
                                    <a href="deleteUser?id=${user.id}" class="action-link">Supprimer</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </section>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
    </main>
</div>

<!-- Inclure le modal pour les messages -->
<jsp:include page="messageModal.jsp" />

</body>
</html>
