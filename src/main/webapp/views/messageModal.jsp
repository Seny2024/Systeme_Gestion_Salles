<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <title>Message</title>
  <link rel="stylesheet" type="text/css" href="css/pop.css">
  <script src="js/modal.js"></script>
</head>
<body>
<div id="modalOverlay" class="modal-overlay" onclick="closeModal()"></div>
<div id="messageModal" class="modal" style="display: block;">
  <p id="modalMessage">Bienvenue dans cette section !</p>
  <button onclick="closeModal()">Fermer</button>
</div>
</body>
</html>
