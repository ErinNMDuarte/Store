<%@page import="controller.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/menuprincipal.css">
<title>Menu Principal</title>
</head>
<body>

<%
HttpSession obj=request.getSession();
String uss=(String)obj.getAttribute("usuario");

%>

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
<label>Bienvenido <%=uss %></label>





</main>

</body>
</html>