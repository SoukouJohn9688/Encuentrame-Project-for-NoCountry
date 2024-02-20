-- Active: 1696892290452@@127.0.0.1@3306
CREATE DATABASE patitasEnEspera
    DEFAULT CHARACTER SET = 'utf8mb4';
    CREATE TABLE roles(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Rol VARCHAR(255)
);

USE patitasEnEspera;


CREATE TABLE roles(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Rol VARCHAR(255)
);




CREATE TABLE usuario(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    mail VARCHAR(255),
    contraseña VARCHAR(255)
);

CREATE TABLE mascota(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    raza VARCHAR(255),
    edad INT,
    descripcion VARCHAR(255),
    ubicacion VARCHAR(255)
);

CREATE TABLE imagen(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    imagen TEXT
);

CREATE TABLE imagenMascota(
    idImagen INT,
    idMascota INT,
    PRIMARY KEY(idImagen, idMascota),
    FOREIGN KEY (idImagen) REFERENCES imagen(id),
    FOREIGN KEY (idMascota) REFERENCES mascota(id)
);