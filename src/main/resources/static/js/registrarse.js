// document.getElementById("registrarseButton").addEventListener("click", function() {
//     let nombre = document.getElementById("nombre").value;
//     let apellido = document.getElementById("apellido").value;
//     let email = document.getElementById("email").value;
//     let password1 = document.getElementById("contraseña").value;
//     let password2 = document.getElementById("confirmarcontraseña").value;

//     if (password1==password2){
//         alert("Los datos se guardaron correctamente");
//         window.location.href="ingresar.html";
//     }else{
//         alert("las contraseñas no coinciden. Por favor, verificalas.")
//     }
// });

document.getElementById("registrarseButton").addEventListener("click", function() {
    let nombre = document.getElementById("nombre").value;
    let apellido = document.getElementById("apellido").value;
    let email = document.getElementById("email").value;
    let password1 = document.getElementById("contraseña").value;
    let password2 = document.getElementById("confirmarcontraseña").value;

    if (password1 === password2) {
        // Crear un objeto con los datos del formulario
        const datos = {
            nombre: nombre,
            apellido: apellido,
            mail: email,
            contraseña: password1
        };

        // Realizar una solicitud POST a tu archivo PHP
        fetch('http://localhost/back-Patitas/registro_usuario.php', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        })
        .then(response => response.json())
        .then(data => {
            // Manejar la respuesta del servidor
            console.log(data);
            // Redirigir o mostrar mensajes según sea necesario
            if (data.mensaje === "Usuario creado exitosamente") {
                alert(data.mensaje);
                window.location.href = "ingresar.html";
            } else {
                alert(data.mensaje);
            }
        })
        .catch(error => {
            console.error(error);
            alert("Hubo un error al procesar la solicitud.");
        });
    } else {
        alert("Las contraseñas no coinciden. Por favor, verifícalas.");
    }
});
