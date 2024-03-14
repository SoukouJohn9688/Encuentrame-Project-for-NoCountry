# c16-53-t-java

Proyecto Encuéntrame

Java version : 17 

# Setup

1. Install MySQL
2. Create database 

```
CREATE DATABASE rescatame;
```

3. To connect to the database you must define the following environment variables with your database username and password respectively:

```
MYSQL_DB_USERNAME
MYSQL_DB_PASSWORD
```


## Notas sobre el proyecto

Proyecto realizado para NoCountry-Simulacion Laboral.

Integrantes del equipo:

Juan Pablo Cano Jaramillo- Backend Developer
Lina Marcela Avila Moreno- Backend Developer
Matias Campopiano- Backend Developer
Santiago Figliuolo- Backend Developer
Ignacio Carballo- HTML/CSS Designer- Initial UI Visual Design.


## Notas Matias
Ultimo commit tengo servicios y controllers de Article y Event, en adicion a mi version de CareGiver que pronto reemplazare con la de Juan, Aun no estan bien probado el CRUD de estas entidades porque no pude crear un Usuario para los articulos y eventos.
Estoy batallando con el MyUser, lo estoy editando para crear algo sencillo que pueda probar con el back, por mas que retroceda un poco en seguridad de momento
---
Cree un GetAllUsers y un GetAllPets que creo que me servira para crear mi RequestAdoption CRUD. Podria evaluar eliminarse estas modificaciones de users y pets, tuve que hacer leves modificaciones en las entidades.

Probablemente tenga que rehacer el CREATE del serviceIMPL si no logro adaptarlo, con ello el Controller tambien, creare un RestController que adaptare a controller luego cuando haya manera de manejar login y sesiones.
Hecho
---
Puedo crear la RequestAdoption, falta capturar la ID de la sesion, que el template se genere como plantilla a partir de ser derivado de una mascota, Ahi Ajusto el formulario para que funcione el metodo.
Correji el asunto de la creacion de imagen y mascota, falta manejar sus contingencias como que reemplaza una imagen previa con su mismo nombre y probablemente no sea facil de relacionarlo con las mascotas.





