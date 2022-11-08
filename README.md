# dss-guia5
Desarrollo de software seguro - guia 5

# Crear base de datos
create database GestionAcad;<br>
use GestionAcad;<br>
create table profesor(<br>
&nbsp;id integer primary key auto_increment,<br>
&nbsp;cedula int unique,<br>
&nbsp;nombre varchar(100),<br>
&nbsp;apellido varchar(100),<br>
&nbsp;facultad varchar(100),<br>
&nbsp;email varchar(100)<br>
);
