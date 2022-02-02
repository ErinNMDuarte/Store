<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/ventas.css">

<title>Insert title here</title>
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
    <legend>Gestion ventas</legend>
    <form action="ServletGestionVentas" method="post">
    	<input type="text" name="cedulacliente" value="${cliente.getDoccli()}" placeholder="cedula">
    	<input type="text" name="nombrecliente" value="${cliente.getNomcli()}" placeholder="nombre">
    	<input type="submit" name="confirmar">
    
    
    <table>
    	<tbody>
    		<tr>
    			<th>Codigo del producto</th>
    			<th>Consultar producto</th>
    			<th>Nombre del producto</th>
    			<th>Cantidad del producto</th>
    			<th>Precio del producto</th>
    		</tr>
    		<tr>
    			<td><input type="text" name="codigo" value="${producto.getCodpro()}"></td>
    			<td><input type="submit" name="conpro" value="Buscar producto"></td>
    			<td><input type="text" class="" name="" value="${producto.getNompro()}"></td>
    			<td><input type="text" class="" name="can" value=""></td>
    			<td><input type="text" class="" name="precio" value="${producto.getPrecioven()}"></td>
    		</tr>
    		
    		<tr>
    			<td><input type="text" name="codigo1" value="${producto1.getCodpro()}"></td>
    			<td><input type="submit" name="conpro1" value="Buscar producto"></td>
    			<td><input type="text" class="" name="" value="${producto1.getNompro()}"></td>
    			<td><input type="text" class="" name="can1" value=""></td>
    			<td><input type="text" class="" name="precio1" value="${producto1.getPrecioven()}"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="codigo2" value="${producto2.getCodpro()}"></td>
    			<td><input type="submit" name="conpro2" value="Buscar producto"></td>
    			<td><input type="text" class="" name="" value="${producto2.getNompro()}"></td>
    			<td><input type="text" class="" name="can2" value=""></td>
    			<td><input type="text" class="" name="precio2" value="${producto2.getPrecioven()}"></td>
    		</tr>
    		<tr>
    			<td><input type="submit" name="total" value="Enviar venta"></td>
    		</tr>
    	
    	</tbody>
    
    </table>
    
    <input type="hidden" name="docus" value="${vs.docus}">
    </form>
    
    
    </fieldset>
    </main>

</body>
</html>