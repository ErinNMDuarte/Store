<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/cliente.css">

<title>Cliente</title>
</head>
<body>
<%
String doc="",nombre="",direccion="",telefono="",email="";
if(request.getParameter("do")!=null){
	doc=request.getParameter("do");
	nombre=request.getParameter("no");
	direccion=request.getParameter("di");
	telefono=request.getParameter("te");
	email=request.getParameter("em");
}
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
<fieldset>
<form action="ServletGestionClientes" method="post">
	<input type="text" name="cedulacliente" value="<%=doc %>" placeholder="Documento">
	<input type="text" name="nombrecliente" value="<%=nombre %>" placeholder="Nombre completo">
	<input type="text" name="direccioncliente" value="<%=direccion %>" placeholder="Direccion">
	<input type="number" name="telefonocliente" value="<%=telefono %>" placeholder="Telefono">
	<input type="email" name="emailcliente" value="<%=email %>" placeholder="Email">
	<input type="submit" name="btnin" class="btnin" value="Ingresar">
    <input type="submit" name="btncon" class="btnin" value="Consultar">
    <input type="submit" name="btneli" class="btnin" value="Eliminar">
    <input type="submit" name="btnact" class="btnin" value="Actualizar">
	
</form>
</fieldset>
</main>
</body>
</html>