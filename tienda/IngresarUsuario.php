<?php
include "conexion.php";
$nombre = $_POST["nombre"];
$clave = $_POST["clave"];
$correo_electronico = $_POST["correo_electronico"];
$direccion = $_POST["direccion"];


$sentencia = $conexion->prepare("INSERT INTO clientes(nombre,clave,correo_electronico,direccion)VALUES('$nombre','$clave','$correo_electronico','$direccion')");
$sentencia->execute();
$resultado = $sentencia->get_result();


$sentencia->close();

$conexion->close();
?>