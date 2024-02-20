<?php

error_reporting(E_ALL);
ini_set('display_errors', '1');

    include 'conexion_be.php';

    $nombre = $_POST['nombre'];
    $apellido = $_POST['apellido'];
    $correo = $_POST['correo'];
    $contrasena = $_POST['contrasena'];
    //encriptamiento de pw
    $contrasena = hash('sha512', $contrasena);

    $query = "INSERT INTO usuario(nombre, apellido, correo, contrasena)
               VALUES ('$nombre','$apellido', '$correo', '$contrasena')";


    //verificacion de correo
    $verificar_correo = mysqli_query($conexion, "SELECT * FROM usuario WHERE mail='$correo' ");
    

    if(mysqli_num_rows($verificar_correo) > 0){
        echo '
        <script>
                alert("Este correo ya está en uso, intente otro");
                window.location = "../registrarse.html"
        </script>
        ';

        exit();
    }
    // //verificacion de user
    // $verificar_usuario = mysqli_query($conexion, "SELECT * FROM usuarios WHERE username='$usuario' ");
    
    // if(mysqli_num_rows($verificar_usuario) > 0){
    //     echo '
    //     <script>
    //             alert("Este usuario ya está en uso, intente otro");
    //             window.location = "../registrarse.php"
    //     </script>
    //     ';

    //     exit();
    // }


    $ejecutar = mysqli_query($conexion, $query);

    if($ejecutar){
        echo '
        <script>
        alert("Usuario creado exitosamente");
        window.location =  "../login.php";
        </script>
    
    ';
    } else{
     echo '
        <script>
        alert("El usuario no se ha registrado");
        window.location =  "../registrarse.php";
        </script>
    
        ';
    }
    mysqli_close($conexion);
?>