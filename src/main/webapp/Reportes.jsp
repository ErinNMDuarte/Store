<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="CSS/reportes.css">
<title>Reportes</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
</head>
<body>
	<header id="headercont" class="encabezado">
        <div id="logo" class="logo">
            <h1></h1>
        </div>
        <nav class="nav" id="links">
            <ul>
                <li><a href="Usuario.jsp">Usuarios</a></li>
                <li><a href="Cliente.jsp">Clientes</a></li>
                <li><a href="Proveedor.jsp">Proveedores</a></li>
                <li><a href="Productos.jsp">Productos</a></li>
                <li><a href="Ventas.jsp">Ventas</a></li>
				<li><a href="Reportes.jsp">Reportes</a></li>            
            </ul>
        </nav>
        
    </header>
    
<main>
<fieldset>
<form>
<input type="button" class="btnconsulus" value="Listado de Usuarios">
<input type="button" class="btnconsulcli" value="Listado de clientes">
<input type="button" class="btnconsulven" value="Ventas por cliente">
</form>
</fieldset>

<table id="tab"></table>
</main>


</body>
</html>