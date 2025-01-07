function validateLoginForm() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    if (username === "" || password === "") {
        alert("Username and password are required.");
        return false;
    }
    return true;
}

function validateRoomForm() {
    var name = document.getElementById('name').value;
    var capacity = document.getElementById('capacity').value;

    if (name === "" || capacity === "") {
        alert("Name and capacity are required.");
        return false;
    }
    return true;
}

function validateReservationForm() {
    var roomId = document.getElementById('roomId').value;
    var reservationDate = document.getElementById('reservationDate').value;

    if (roomId === "" || reservationDate === "") {
        alert("Room and reservation date are required.");
        return false;
    }
    return true;
}
