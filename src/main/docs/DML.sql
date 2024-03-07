USE rescatame;
show tables;
select*from request_adoption;
select*from pet;
select*from care_giver;
select*From my_user;
INSERT INTO `rescatame`.`my_user` (`birthdate`, `email`, `name`, `surname`, `password`, `role`) VALUES
('1990-05-15', 'user1@example.com', 'John', 'Doe', 'password1', 'USER'),
('1985-09-23', 'user2@example.com', 'Jane', 'Smith', 'password2', 'USER'),
('1998-03-07', 'user3@example.com', 'Michael', 'Johnson', 'password3', 'USER'),
('1982-12-10', 'user4@example.com', 'Emily', 'Williams', 'password4', 'MODERATOR'),
('1995-06-28', 'user5@example.com', 'Daniel', 'Brown', 'password5', 'ADMIN'),
('1945-06-21', 'user6@example.com', 'Genghis', 'Khan', 'password6', 'ADMIN');

INSERT INTO `rescatame`.`article` (`content`, `title`, `user_id`) VALUES
('Contenido del artículo 1', 'Título del artículo 1', 1),
('Contenido del artículo 2', 'Título del artículo 2', 2),
('Contenido del artículo 3', 'Título del artículo 3', 3),
('Contenido del artículo 4', 'Título del artículo 4', 4),
('Contenido del artículo 5', 'Título del artículo 5', 5),
('Contenido del artículo 6', 'Título del artículo 6', 6);

INSERT INTO `rescatame`.`care_giver` (`id`, `adress`, `city`, `email`, `name`, `phone`, `surname`) VALUES
('CG1', 'Calle A 123', 'Ciudad 1', 'caregiver1@example.com', 'Carlos', 123456789, 'Gómez'),
('CG2', 'Calle B 456', 'Ciudad 2', 'caregiver2@example.com', 'Ana', 987654321, 'Pérez'),
('CG3', 'Calle C 789', 'Ciudad 3', 'caregiver3@example.com', 'Pedro', 555666777, 'Rodríguez'),
('CG4', 'Calle D 012', 'Ciudad 4', 'caregiver4@example.com', 'María', 111222333, 'López'),
('CG5', 'Calle E 345', 'Ciudad 5', 'caregiver5@example.com', 'Javier', 444555666, 'Martínez');

INSERT INTO `rescatame`.`events` (`address`, `city`, `content`, `date_time`, `title`, `id_admin`) VALUES
('Dirección del Evento 1', 'Ciudad 1', 'Contenido del Evento 1', '2024-02-21 14:30:00', 'Evento 1', 1),
('Dirección del Evento 2', 'Ciudad 2', 'Contenido del Evento 2', '2024-02-22 15:45:00', 'Evento 2', 2),
('Dirección del Evento 3', 'Ciudad 3', 'Contenido del Evento 3', '2024-02-23 16:30:00', 'Evento 3', 3),
('Dirección del Evento 4', 'Ciudad 4', 'Contenido del Evento 4', '2024-02-24 17:15:00', 'Evento 4', 4),
('Dirección del Evento 5', 'Ciudad 5', 'Contenido del Evento 5', '2024-02-25 18:00:00', 'Evento 5', 5);

INSERT INTO `rescatame`.`pet` (`adoptado`, `color`, `descripcion`, `edad_meses`, `raza`, `pet_id`) VALUES
(0, 'Negro', 'Gatito juguetón', 6, 'Siamés', 'a4f94e9a-4d7b-4c3c-b0d5-09f49d71c523'),
(1, 'Blanco y Marrón', 'Perrito amigable', 12, 'Labrador', '8e2bf6fd-7a15-492a-bc8d-3e0a8dcf7b90'),
(0, 'Gris', 'Gatito tranquilo', 8, 'Persa', 'f1c15f9b-6bfc-45a8-8a9d-d91e6aeb13cf'),
(1, 'Negro y Blanco', 'Perrito enérgico', 10, 'Beagle', '5d6a7f83-9f15-4e36-a3bf-8625f0a8a7d2'),
(0, 'Marrón', 'Gatito curioso', 7, 'Bengalí', 'b0e2d4c1-98a7-4bfb-ba15-743f1e68a390');

INSERT INTO `rescatame`.`request_adoptions` (`adoption_status`, `creation_date`, `user_id`, `pet_id`) VALUES
('WAITING', '2024-02-21 10:30:00', 1, 1),
('APPROVED', '2024-02-22 11:45:00', 2, 2),
('WAITING', '2024-02-23 12:30:00', 3, 3),
('DENIED', '2024-02-24 13:15:00', 4, 4),
('WAITING', '2024-02-25 14:00:00', 5, 5);

INSERT INTO `rescatame`.`donaciones_historico` (`name_donante`, `email_donante`, `medio_pago`, `monto`, `fecha_hora`) VALUES
('Esteban', 'correo1@example.com', 'Credito', 100.00, CURRENT_TIMESTAMP),
('Marcelo', 'user2@hotmail.com', 'Debito', 200.00, CURRENT_TIMESTAMP),
('Penelope', 'correo_ejemplo3@gmail.com', 'Transferencia', 300.00, CURRENT_TIMESTAMP),
('Sofia', 'donante4@outlook.com', 'Credito', 400.00, CURRENT_TIMESTAMP),
('Federico', 'mi_correo5@yahoo.com', 'Debito', 500.00, CURRENT_TIMESTAMP);

INSERT INTO `rescatame`.`respuesta_evento` (`id_evento`, `id_user`, `respuesta`) VALUES
(1, 1, 'Interesado'),
(2, 2, 'No Interesado'),
(3, 3, 'No Seguro'),
(4, 4, 'Interesado'),
(5, 5, 'No Seguro');