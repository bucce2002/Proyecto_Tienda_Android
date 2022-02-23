<?php
$hostname="localhost";
$database="tienda";
$username="root";
$password="";

$conexion = mysqli_connect($hostname,$username,$password,$database);
if($conexion->connect_errno){
	echo "No ha sido posible conectarse a la base de datos";
}

?>
