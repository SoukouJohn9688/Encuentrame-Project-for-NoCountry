<?php
session_start();

include 'conexion_be.php';

$correo = $_POST['correo'];
$contrasena = $_POST['contrasena'];
$contrasena = hash('sha512', $contrasena);

$validar_login = mysqli_query($conexion, "SELECT * FROM usuario WHERE mail='$correo' AND contraseña='$contrasena'");

if(mysqli_num_rows($validar_login) > 0){
    $_SESSION['usuario'] = $correo;
    // Autenticación exitosa
    $response = array("success" => true);
    header('Content-Type: application/json');
    echo json_encode($response);
} else {
    // Autenticación fallida
    $response = array("success" => false);
    echo json_encode($response);
}
?>





