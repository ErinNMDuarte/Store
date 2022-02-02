<%@page import="controller.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/Login.css">

<title>Login</title>
</head>

<body>
<header id="headercont" class="encabezado">
	<div id="logo" class="ellogo">
		<h1></h1>
        <div class="logo"></div>
	</div>

</header>
<main>


<fieldset>  
    <div class="titulo">Bienvenido </div>
    <form action="ServletLogin" method="post">
        <input type="text" name="usu" placeholder="Usuario">        
        <input type="password" name="pass" placeholder="Contraseña">
        <input type="submit" name="btnlog" class="btnlog" value="Enviar">
    </form>
</fieldset>

</main>

</body>
</html>