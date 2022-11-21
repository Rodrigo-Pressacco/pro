CREATE SCHEMA IF NOT EXISTS `neotravel`;

DROP TABLE IF EXISTS `neotravel`.`categorias`;
CREATE TABLE `neotravel`.`categorias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `url_imagen` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
  DROP TABLE IF EXISTS `neotravel`.`imagenes`;
  CREATE TABLE `neotravel`.`imagenes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `url_imagen` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
DROP TABLE IF EXISTS `neotravel`.`caracteristicas`;
CREATE TABLE `neotravel`.`caracteristicas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `icono` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
DROP TABLE IF EXISTS `neotravel`.`productos`;
CREATE TABLE `neotravel`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `latitud` FLOAT NOT NULL,
  `longitud` FLOAT NOT NULL,
  PRIMARY KEY (`id`)); 

DROP TABLE IF EXISTS `neotravel`.`ciudades`;
CREATE TABLE `neotravel`.`ciudades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)); 
  
DROP TABLE IF EXISTS `neotravel`.`usuarios`;
CREATE TABLE `neotravel`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)); 
  
DROP TABLE IF EXISTS `neotravel`.`roles`;
CREATE TABLE `neotravel`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)); 
  
DROP TABLE IF EXISTS `neotravel`.`reservas`;
CREATE TABLE `neotravel`.`reservas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hora_llegada` TIME NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_final` DATE NOT NULL,
  `ciudad_usuario` VARCHAR(45) NOT NULL,
  `mensaje_duenio` VARCHAR(255),
  `covid` INT NOT NULL,
  PRIMARY KEY (`id`));