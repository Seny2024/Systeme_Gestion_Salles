function showMessage(message) {
    const modal = document.getElementById('messageModal');
    const overlay = document.getElementById('modalOverlay');
    const modalMessage = document.getElementById('modalMessage');

    modalMessage.textContent = message;
    modal.style.display = 'block';
    overlay.style.display = 'block';
}

function closeModal() {
    document.getElementById('messageModal').style.display = 'none';
    document.getElementById('modalOverlay').style.display = 'none';
}
