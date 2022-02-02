<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="CSS/usuario.css">
<title>Usuarios</title>
</head>
<body>
<%
String doc="",nombre="",email="",usuario="",pass="";
if(request.getParameter("do")!= null){
	doc=request.getParameter("do");
	nombre=request.getParameter("no");
	email=request.getParameter("em");
	usuario=request.getParameter("u");
	pass=request.getParameter("pa");
}
%>
	<header id="headercont" class="encabezado">
        <div id="logo" class="logo">
            <h1></h1>
        </div>
        <nav class="nav" id="links">
            <ul>
                <li><a href="Usuario.jsp">Usuarios</a></li>
                <li><li>
                <li><a href="Cliente.jsp">Clientes</a></li>
                <li><li>
                <li><a href="Proveedor.jsp">Proveedores</a></li>
                <li><li>
                <li><a href="Productos.jsp">Productos</a></li>
                <li><li>
                <li><a href="Ventas.jsp">Ventas</a></li>
				<li><li>
				<li><a href="Reportes.jsp">Reportes</a></li>            
            </ul>
        </nav>
        
    </header>
<main>
<fieldset>
<form action="ServletGestionUsuarios" method="post">
	<input type="text" name="cedula" value="<%=doc %>" placeholder="Documento">
	<input type="text" name="nombre" value="<%=nombre %>" placeholder="Nombre completo">
	<input type="email" name="correo" value="<%=email %>" placeholder="Correo Electronico">
	<div id="us" class="us">
        <input type="text" name="usuario" value="<%=usuario %>" placeholder="Usuario">
	    <input type="password" name="password" value="<%=pass %>" placeholder="Contraseña">
	</div>
    <div class="btn">
        <input type="submit" name="btnin" class="btnin" value="Ingresar">
        <input type="submit" name="btncon" class="btnin" value="Consultar">
        <input type="submit" name="btneli" class="btnin" value="Eliminar">
        <input type="submit" name="btnact" class="btnin" value="Actualizar">

    </div>
</form>
</fieldset>
</main>
</body>
</html>