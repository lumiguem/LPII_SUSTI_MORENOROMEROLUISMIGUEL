<%@page import="model.TblProductosusti"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegistrarProducto</title>
</head>
<body>
    <h1>Registrar Proveedor</h1>
    <form method="post" action="ControladorProducto">
        <table>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" required></td>
            </tr>
            <tr>
                <td>Precio Venta</td>
                <td><input type="text" name="preVenta" required></td>
            </tr>
            <tr>
                <td>Precio Compra</td>
                <td><input type="text" name="preCompra" required></td>
            </tr>
            <tr>
                <td>Estado</td>
                <td><input type="text" name="estado" required></td>
            </tr>
            <tr>
                <td>Descripcion</td>
                <td><input type="date" name="descripcion" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Registrar" class="submit-btn"></td>
            </tr>
        </table>
    </form>
    
        <% 
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje != null) { 
    %>
        <div class="message"><%= mensaje %></div>
    <% 
    } 
    %>
    
    <h1>Listado de Productos</h1>
    
    <table>
        <tr>
            <th>Código</th>
            <th>Nombre</th>
            <th>Precio Venta</th>
            <th>Precio Compra</th>
            <th>Estado</th>
            <th>Descripcion</th>
            <th colspan="2">Acciones</th>
        </tr>
        <%
        List<TblProductosusti> listadoproductos = (List<TblProductosusti>) request.getAttribute("listado");
        if (listadoproductos != null) {
            for (TblProductosusti prod : listadoproductos) {
        %>
            <tr>
                <td><%= prod.getIdproductosusti() %></td>
                <td><%= prod.getNombresusti() %></td>
                <td><%= prod.getPrecioventasusti()%></td>
                <td><%= prod.getPreciocompsusti() %></td>
                <td><%= prod.getEstadosusti() %></td>
                <td><%= prod.getDescripsusti() %></td>

                <td><a href="ControladorProducto?accion=Modificar&cod=<%= prod.getIdproductosusti() %>" class="update-btn">Actualizar</a></td>
                <td><a href="ControladorProducto?accion=Eliminar&cod=<%= prod.getIdproductosusti() %>" class="delete-btn">Eliminar</a></td>
            </tr>
        <%
            }
        }
        %>
    </table>
</body>
</html>