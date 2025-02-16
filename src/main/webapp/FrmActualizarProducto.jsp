<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Actualizar Proveedor</h1>

    <form method="post" action="ControladorProducto">
        <% 
        String codigo = request.getAttribute("codigo").toString();
        String nombre = (request.getAttribute("nombre") != null) ? request.getAttribute("nombre").toString() : "";
        String preVenta = (request.getAttribute("preVenta") != null) ? request.getAttribute("preVenta").toString() : "";
        String preCompra = (request.getAttribute("preCompra") != null) ? request.getAttribute("preCompra").toString() : "";
        String estado = (request.getAttribute("estado") != null) ? request.getAttribute("estado").toString() : "";
        String descripcion = (request.getAttribute("descripcion") != null) ? request.getAttribute("descripcion").toString() : "";
        %>
        
        <input type="hidden" name="codigo" value="<%= codigo %>">
        
        <table>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" value="<%= nombre %>" required></td>
            </tr>
            <tr>
                <td>RUC</td>
                <td><input type="text" name="preVenta" value="<%= preVenta %>" required></td>
            </tr>
            <tr>
                <td>Razón Social</td>
                <td><input type="text" name="preCompra" value="<%= preCompra %>" required></td>
            </tr>
            <tr>
                <td>Estado</td>
                <td><input type="text" name="estado" value="<%= estado %>" required></td>
            </tr>
            <tr>
                <td>Descripcion</td>
                <td><input type="text" name="descripcion" value="<%= descripcion %>" required></td>
            </tr>
    
                <td colspan="2"><input type="submit" value="Actualizar" class="submit-btn"></td>
            </tr>
        </table>
    </form>


</body>
</html>