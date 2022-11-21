INSERT INTO `neotravel`.`categorias` (titulo, descripcion , url_imagen) values ( 'HOTELES','2 hoteles','https://neotravelbucket.s3.us-east-2.amazonaws.com/Categorias/HOTELES.jpg');
INSERT INTO `neotravel`.`categorias` (titulo, descripcion , url_imagen) values ( 'HOSTELS','2 hostels','https://neotravelbucket.s3.us-east-2.amazonaws.com/Categorias/HOSTELS.jpg');
INSERT INTO `neotravel`.`categorias` (titulo, descripcion , url_imagen) values ( 'DEPARTAMENTOS','2 departamentos','https://neotravelbucket.s3.us-east-2.amazonaws.com/Categorias/DEPARTAMENTOS.jpg');
INSERT INTO `neotravel`.`categorias` (titulo, descripcion , url_imagen) values ( 'BED & BREAKFAST','2 bed & breakfasts','https://neotravelbucket.s3.us-east-2.amazonaws.com/Categorias/BED+&+BREAKFAST.jpg');

INSERT INTO `neotravel`.`ciudades` (nombre, pais) values ( 'Cleveland','Estados Unidos');
INSERT INTO `neotravel`.`ciudades` (nombre, pais) values ( 'Playa del Carmen','México');
INSERT INTO `neotravel`.`ciudades` (nombre, pais) values ( 'San Carlos de Bariloche','Argentina');
INSERT INTO `neotravel`.`ciudades` (nombre, pais) values ( 'Bora Bora','Polinesia Francesa');
INSERT INTO `neotravel`.`ciudades` (nombre, pais) values ( 'Manhattan','Estados Unidos');
INSERT INTO `neotravel`.`ciudades` (nombre, pais) values ( 'Las Vegas','Estados Unidos');
INSERT INTO `neotravel`.`ciudades` (nombre, pais) values ( 'Dubai','Emiratos Árabes Unidos');
INSERT INTO `neotravel`.`ciudades` (nombre, pais) values ( 'París','Francia');

INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Wifi','fas fa-wifi');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Pileta','fas fa-swimmer');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Estacionamiento gratuito','fas fa-car');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Aire acondicionado','far fa-snowflake');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'No fumador','fas fa-smoking-ban');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Televisor','fas fa-tv');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Apto mascotas','fas fa-paw-alt');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Cocina','far fa-oven');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Tarjeta de crédito','fas fa-credit-card');
INSERT INTO `neotravel`.`caracteristicas` (nombre, icono) values ( 'Check-in','far fa-clock');

INSERT INTO `neotravel`.`productos` (nombre, descripcion, categoria_id, ciudad_id) values ( 'Renaissance','Descubra una estancia satisfactoria en el Renaissance Cleveland Hotel. Nuestro hotel en el centro de Cleveland ofrece todo lo que necesita para una experiencia de viaje inolvidable.', 1, 1);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, categoria_id, ciudad_id) values ( 'Sandos Playacar','Ubicado en Playa del Carmen, el Hotel Sandos Playacar cuenta con una playa privada, piscinas para niños o adultos y variadas opciones gastronómicas, además de fiestas temáticas y clubes para niños y adolescentes. ', 1, 2);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, categoria_id, ciudad_id) values ( 'Nap York Youth','El Nap York Youth Hostel dispone de salón compartido y se encuentra en Nueva York, en el estado de Nueva York, a 300 metros del teatro Broadway y del Carnegie Hall. ', 2, 5);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, categoria_id, ciudad_id) values ( 'Sin City','Este hostel se encuentra en Las Vegas y ofrece habitaciones con wifi gratis. Todos los días se sirve un desayuno gratuito que incluye magdalenas, gofres, tostadas, café y té.', 2, 6);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, categoria_id, ciudad_id) values ( 'Sonder Towers','Situado en Dubái, en el Emirato de Dubái, con el centro comercial City Walk y el Burj Khalifa El Sonder l Downtown Towers ofrece alojamiento con wifi gratis y estacionamiento privado gratuito en las inmediaciones.', 3, 7);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, categoria_id, ciudad_id) values ( 'Le Petit Apartment','Un pequeño apartamento parisino en Yakarta, cerca del aeropuerto y cerca del acceso a la autopista periférica que le conecta con el resto de Yakarta.', 3, 8);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, categoria_id, ciudad_id) values ( 'Latitud Patagonia','Las habitaciones de los huéspedes incluyen frigorífico y cocinita, y Latitud Patagonia Apart Hotel te ayuda a que estés conectado, ya que dispone de wifi gratuito.', 4, 3);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, categoria_id, ciudad_id) values ( 'Lokai house','El Lokai house, situado en Bora Bora, a 2,3 km de la playa de Bora Bora Bora Bora Bora, ofrece alojamiento con jardín, aparcamiento privado gratuito y terraza. El hostal cuenta con habitaciones familiares.', 4, 4);

INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (1,1);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (1,3);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (1,4);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (1,5);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (2,1);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (2,8);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (2,9);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (2,3);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (3,3);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (3,1);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (3,8);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (3,5);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (4,2);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (4,6);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (4,5);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (4,10);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (5,1);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (5,2);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (5,7);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (5,8);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (6,4);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (6,7);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (6,2);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (6,1);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (7,6);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (7,7);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (7,3);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (7,1);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (8,2);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (8,1);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (8,4);
INSERT INTO `neotravel`.`atributos` (productos_id, caracteristicas_id) values (8,8);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Renaissance Hotel', 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Renaissance+Hotel/Portada.jpg',1);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Renaissance+Hotel/Dormitorio.jpg',1);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Renaissance+Hotel/Baño.jpg',1);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Renaissance+Hotel/Desayuno.jpg',1);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Renaissance+Hotel/Sala+de+estar.jpg',1);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Sandos Hotel', 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sandos+Hotel/Portada.jpg',2);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sandos+Hotel/Dormitorio.jpg',2);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sandos+Hotel/Baño.jpg',2);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sandos+Hotel/Desayuno.jpg',2);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sandos+Hotel/Sala+de+estar.jpg',2);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Nap Hostel', 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Nap+Hostel/Portada.jpg',3);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Nap+Hostel/Dormitorio.jpg',3);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Nap+Hostel/Baño.jpg',3);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Nap+Hostel/Desayuno.jpg',3);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Nap+Hostel/Sala+de+estar.jpg',3);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Sin City Hostel', 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sin+City+Hostel/Portada.jpg',4);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sin+City+Hostel/Dormitorio.jpg',4);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sin+City+Hostel/Baño.jpg',4);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sin+City+Hostel/Desayuno.jpg',4);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sin+City+Hostel/Sala+de+estar.jpg',4);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Sonder dtpo', 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sonder+dtpo/Portada.jpg',5);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sonder+dtpo/Dormitorio.jpg',5);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sonder+dtpo/Baño.jpg',5);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sonder+dtpo/Desayuno.jpg',5);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Sonder+dtpo/Sala+de+estar.jpg',5);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Petit dpto', 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Petit+dpto/Portada.jpg',6);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Petit+dpto/Dormitorio.jpg',6);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Petit+dpto/Baño.jpg',6);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Petit+dpto/Desayuno.jpg',6);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Petit+dpto/Sala+de+estar.jpg',6);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Patagonia B&B', 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Patagonia+B/Portada&B.jpg',7);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Patagonia+B/Dormitorio.jpg',7);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Patagonia+B/Baño.jpg',7);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Patagonia+B/Desayuno.jpg',7);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Patagonia+B/Sala+de+estar.jpg',7);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Lokai B&B', 'https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Lokai+B/Portada&B.jpg',8);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Lokai+B/Dormitorio.jpg',8);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Lokai+B/Baño.jpg',8);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Lokai+B/Desayuno.jpg',8);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://neotravelbucket.s3.us-east-2.amazonaws.com/Alojamientos/Lokai+B/Sala+de+estar.jpg',8);
