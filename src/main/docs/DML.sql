USE rescatame;
INSERT INTO `rescatame`.`users` (`birthdate`, `email`, `first_name`, `last_name`, `password`, `role`) VALUES
('1990-05-15', 'user1@example.com', 'John', 'Doe', 'password1', 'USER'),
('1985-09-23', 'user2@example.com', 'Jane', 'Smith', 'password2', 'USER'),
('1998-03-07', 'user3@example.com', 'Michael', 'Johnson', 'password3', 'USER'),
('1982-12-10', 'user4@example.com', 'Emily', 'Williams', 'password4', 'MODERATOR'),
('1995-06-28', 'user5@example.com', 'Daniel', 'Brown', 'password5', 'ADMIN');

INSERT INTO `rescatame`.`article` (`contenido`, `titulo`, `id_admin`) VALUES
('Contenido del artículo 1', 'Título del artículo 1', 1),
('Contenido del artículo 2', 'Título del artículo 2', 2),
('Contenido del artículo 3', 'Título del artículo 3', 3),
('Contenido del artículo 4', 'Título del artículo 4', 4),
('Contenido del artículo 5', 'Título del artículo 5', 5);

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

INSERT INTO `rescatame`.`pet` (`adoptado`, `color`, `descripcion`, `edad_meses`, `raza`, `id_care_giver`) VALUES
(0, 'Negro', 'Gatito juguetón', 6, 'Siamés', 'CG1'),
(1, 'Blanco y Marrón', 'Perrito amigable', 12, 'Labrador', 'CG2'),
(0, 'Gris', 'Gatito tranquilo', 8, 'Persa', 'CG3'),
(1, 'Negro y Blanco', 'Perrito enérgico', 10, 'Beagle', 'CG4'),
(0, 'Marrón', 'Gatito curioso', 7, 'Bengalí', 'CG5');

INSERT INTO `rescatame`.`request_adoptions` (`adoption_status`, `creation_date`, `user_id`, `pet_id`) VALUES
('WAITING', '2024-02-21 10:30:00', 1, 1),
('APPROVED', '2024-02-22 11:45:00', 2, 2),
('WAITING', '2024-02-23 12:30:00', 3, 3),
('DENIED', '2024-02-24 13:15:00', 4, 4),
('WAITING', '2024-02-25 14:00:00', 5, 5);