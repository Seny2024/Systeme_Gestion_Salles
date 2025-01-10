<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Edit User</title>
  <link rel="stylesheet" type="text/css" href="css/style_edit.css">
</head>
<body>
<div class="reservations-container">
  <h2>Modifier l'utilisateur</h2>
  <form class="custom-form" action="editUser" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <label for="username">Nom utilisateur :</label>
    <input type="text" id="username" name="username" value="${user.username}" required>
    <label for="password">Mot de passe:</label>
    <input type="password" id="password" name="password" value="${user.password}" required>
    <label for="role">Role:</label>
    <select id="role" name="role" required>
      <option value="admin" ${user.role == 'admin' ? 'selected' : ''}>admin</option>
      <option value="client" ${user.role == 'user' ? 'selected' : ''}>user</option>
    </select>
    <button type="submit">Mettre à jour</button>
  </form>

  <a href="dashboard">Retour</a>
</div>
</body>
</html>
