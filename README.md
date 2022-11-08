# dss-guia5
Desarrollo de software seguro - guia 5

# Crear base de datos
create database GestionAcad;
use GestionAcad;
# Crear tabla profesores
create table profesor(
id integer primary key auto_increment,
cedula int unique,
nombre varchar(100),
apellido varchar(100),
facultad varchar(100),
email varchar(100)
);
