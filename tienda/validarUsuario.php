<?php
include "conexion.php";
$clave = $_POST["clave"];
$correo_electronico = $_POST["correo_electronico"];

$sentencia = mysqli_query($conexion, "SELECT * FROM clientes WHERE correo_electronico='$correo_electronico' AND clave='$clave'");

$numerofilas = mysqli_affected_rows($conexion);

if ($numerofilas > 0) {
	echo "200";
}else{
	echo "400";
}







$sentencia->close();

$conexion->close();
?>