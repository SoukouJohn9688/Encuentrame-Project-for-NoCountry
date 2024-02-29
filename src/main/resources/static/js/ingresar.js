document.getElementById("loginButton").addEventListener("click",function(){
    let nombre = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    alert("Se inicio sesión correctamente");
    window.location.href="index.html"
});