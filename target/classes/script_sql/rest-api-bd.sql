CREATE DATABASE rest_api;
USE rest_api;

CREATE TABLE equipos(
id int AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(30),
departamento VARCHAR(30),
estadio VARCHAR(30)
)