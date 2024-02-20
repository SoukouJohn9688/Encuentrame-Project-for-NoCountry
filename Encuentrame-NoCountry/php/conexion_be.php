<?php
    $conexion = mysqli_connect("localhost", "root", "", "patitasEnEspera");

    // Verifica si la conexión fue exitosa
    if (!$conexion) {
        // Si la conexión falla, puedes manejar el error aquí si es necesario
        die("Error de conexión: " . mysqli_connect_error());
    }
?>