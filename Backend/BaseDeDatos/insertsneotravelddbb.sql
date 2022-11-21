INSERT INTO `neotravel`.`categorias` (titulo, descripcion , url_imagen) values ( 'HOTELES','2 hoteles','https://images.unsplash.com/photo-1590073242678-70ee3fc28e8e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1121&q=80');
INSERT INTO `neotravel`.`categorias` (titulo, descripcion , url_imagen) values ( 'HOSTELS','2 hostels','https://images.unsplash.com/photo-1520277739336-7bf67edfa768?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1332&q=80');
INSERT INTO `neotravel`.`categorias` (titulo, descripcion , url_imagen) values ( 'DEPARTAMENTOS','2 departamentos','https://images.unsplash.com/photo-1554995207-c18c203602cb?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80');
INSERT INTO `neotravel`.`categorias` (titulo, descripcion , url_imagen) values ( 'BED & BREAKFAST','2 bed & breakfasts','https://cdn.pixabay.com/photo/2015/06/08/15/02/breakfast-801827_960_720.jpg');

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

INSERT INTO `neotravel`.`productos` (nombre, descripcion, latitud, longitud, categoria_id, ciudad_id) values ( 'Renaissance','Descubra una estancia satisfactoria en el Renaissance Cleveland Hotel. Nuestro hotel en el centro de Cleveland ofrece todo lo que necesita para una experiencia de viaje inolvidable.', 41.49699646919508, -81.66775293868895, 1, 1);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, latitud, longitud, categoria_id, ciudad_id) values ( 'Sandos Playacar','Ubicado en Playa del Carmen, el Hotel Sandos Playacar cuenta con una playa privada, piscinas para niños o adultos y variadas opciones gastronómicas, además de fiestas temáticas y clubes para niños y adolescentes. ', 20.63485117289437, -87.06467924495634, 1, 2);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, latitud, longitud, categoria_id, ciudad_id) values ( 'Nap York Youth','El Nap York Youth Hostel dispone de salón compartido y se encuentra en Nueva York, en el estado de Nueva York, a 300 metros del teatro Broadway y del Carnegie Hall. ', 40.768588098238496, -73.96968739189255, 2, 5);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, latitud, longitud, categoria_id, ciudad_id) values ( 'Sin City','Este hostel se encuentra en Las Vegas y ofrece habitaciones con wifi gratis. Todos los días se sirve un desayuno gratuito que incluye magdalenas, gofres, tostadas, café y té.', 36.09898539152328, -115.18127185974173, 2, 6);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, latitud, longitud, categoria_id, ciudad_id) values ( 'Sonder Towers','Situado en Dubái, en el Emirato de Dubái, con el centro comercial City Walk y el Burj Khalifa El Sonder l Downtown Towers ofrece alojamiento con wifi gratis y estacionamiento privado gratuito en las inmediaciones.', 25.20090015058746, 55.26756539346208, 3, 7);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, latitud, longitud, categoria_id, ciudad_id) values ( 'Le Petit Apartment','Un pequeño apartamento parisino en Yakarta, cerca del aeropuerto y cerca del acceso a la autopista periférica que le conecta con el resto de Yakarta.', 48.85473641796258, 2.2952393533019197, 3, 8);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, latitud, longitud, categoria_id, ciudad_id) values ( 'Latitud Patagonia','Las habitaciones de los huéspedes incluyen frigorífico y cocinita, y Latitud Patagonia Apart Hotel te ayuda a que estés conectado, ya que dispone de wifi gratuito.', -41.12207610641024, -71.36738061912166, 4, 3);
INSERT INTO `neotravel`.`productos` (nombre, descripcion, latitud, longitud, categoria_id, ciudad_id) values ( 'Lokai house','El Lokai house, situado en Bora Bora, a 2,3 km de la playa de Bora Bora Bora Bora Bora, ofrece alojamiento con jardín, aparcamiento privado gratuito y terraza. El hostal cuenta con habitaciones familiares.', -16.50789502384443, -151.75071951851663, 4, 4);

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

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Renaissance Hotel', 'https://media.istockphoto.com/photos/downtown-cleveland-hotel-entrance-and-waiting-taxi-cab-picture-id472899538?b=1&k=20&m=472899538&s=170667a&w=0&h=oGDM26vWKgcKA3ARp2da-H4St2dMEhJg23TTBeJgPDE=',1);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://images.unsplash.com/photo-1618773928121-c32242e63f39?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80',1);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://images.unsplash.com/photo-1576698483491-8c43f0862543?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=348&q=80',1);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://images.unsplash.com/photo-1540304453527-62f979142a17?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80',1);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://images.unsplash.com/photo-1583953458882-302655b5c376?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80',1);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Sandos Hotel', 'https://images.unsplash.com/photo-1582719508461-905c673771fd?ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8aG90ZWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60',2);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://images.unsplash.com/photo-1590073242678-70ee3fc28e8e?ixid=MnwxMjA3fDF8MHxzZWFyY2h8MXx8aG90ZWwlMjByb29tfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60',2);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://images.unsplash.com/photo-1587527901949-ab0341697c1e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80',2);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://images.unsplash.com/photo-1596701062351-8c2c14d1fdd0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80',2);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://images.unsplash.com/photo-1560624052-449f5ddf0c31?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=435&q=80',2);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Nap Hostel', 'https://media.istockphoto.com/photos/dormitory-room-in-the-modern-hostel-picture-id910999556?b=1&k=20&m=910999556&s=170667a&w=0&h=8Ppqwt74V-aaXr4vN2iu5XOv87H0nhJh64am-0bYPLc=',3);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://images.unsplash.com/photo-1520277739336-7bf67edfa768?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80',3);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://images.unsplash.com/photo-1566681855366-75a2da1c7221?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80',3);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://images.unsplash.com/photo-1535479939465-f597a4f58943?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80',3);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://images.unsplash.com/photo-1551133988-ad26c02243e2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80',3);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Sin City Hostel', 'https://media.istockphoto.com/photos/youth-hostel-dorm-room-picture-id182498079?b=1&k=20&m=182498079&s=170667a&w=0&h=Atdn_7sfYF1rBo7JjGGHxUTysDq_lHnKLOVbWnXbLl0=',4);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://images.unsplash.com/photo-1555854877-bab0e564b8d5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=869&q=80',4);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://images.unsplash.com/photo-1558211583-03ed8a0b3d5f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80',4);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://images.unsplash.com/photo-1528113196596-82172203a1df?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80',4);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://images.unsplash.com/photo-1599619351208-3e6c839d6828?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=872&q=80',4);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Sonder dtpo', 'https://media.istockphoto.com/photos/modern-living-room-interior-3d-render-picture-id1293762741?b=1&k=20&m=1293762741&s=170667a&w=0&h=2RI8SmBN4MrEZuTvdwRzaeB887x-dukFcQBpyQ-qwS4=',5);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://images.unsplash.com/photo-1585128792103-0b591f96512e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80',5);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80',5);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://images.unsplash.com/photo-1504754524776-8f4f37790ca0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80',5);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://images.unsplash.com/photo-1630703125789-6416b14d1705?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80',5);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Petit dpto', 'https://media.istockphoto.com/photos/digitally-generated-domestic-bedroom-interior-picture-id1266344101?b=1&k=20&m=1266344101&s=170667a&w=0&h=_mEuZIgaXh1cRjzlrGybXRoCfGqKLvPiL1EP0LGOG2o=',6);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://images.unsplash.com/photo-1620332372374-f108c53d2e03?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=872&q=80',6);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://images.unsplash.com/photo-1586798271654-0471bb1b0517?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=385&q=80',6);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://images.unsplash.com/photo-1465014925804-7b9ede58d0d7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=476&q=80',6);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://images.unsplash.com/photo-1520699049698-acd2fccb8cc8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80',6);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Patagonia B&B', 'https://images.unsplash.com/photo-1566073771259-6a8506099945?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8aG90ZWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=60',7);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://images.unsplash.com/photo-1621891334481-5c14b369d9d7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=871&q=80',7);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://images.unsplash.com/photo-1564540583246-934409427776?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=853&q=80',7);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://images.unsplash.com/photo-1491273289208-9340cb42e5d9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=465&q=80',7);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://images.unsplash.com/photo-1518733057094-95b53143d2a7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=365&q=80',7);

INSERT INTO `neotravel`.`imagenes` ( titulo, url_imagen, productos_id) values ( 'Portada Lokai B&B', 'https://media.istockphoto.com/photos/open-door-to-guest-bedroom-with-a-cute-sign-that-says-be-our-guest-picture-id1184920990?b=1&k=20&m=1184920990&s=170667a&w=0&h=4CLxWHhU62z00yezmhCUtDaFJ4ZIXvDuFa-rFHixt6w=',8);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Dormitorio','https://images.unsplash.com/photo-1590675560125-0d832b9d719e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=389&q=80',8);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Baño','https://images.unsplash.com/photo-1584622650111-993a426fbf0a?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80',8);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Desayuno','https://images.unsplash.com/photo-1528699633788-424224dc89b5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=433&q=80',8);
INSERT INTO `neotravel`.`imagenes` (titulo, url_imagen, productos_id) values ('Sala de estar','https://images.unsplash.com/photo-1582731489225-24fc0a720737?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80',8);

INSERT INTO `neotravel`.`roles` (nombre) values ( 'admin');
INSERT INTO `neotravel`.`roles` (nombre) values ( 'user');