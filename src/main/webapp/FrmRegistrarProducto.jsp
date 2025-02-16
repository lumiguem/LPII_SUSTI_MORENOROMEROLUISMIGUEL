<%@page import="model.TblProductosusti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Producto</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .container {
            width: 90%;
            max-width: 600px;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }
        .btn:hover {
            background: #0056b3;
        }
        .table-container {
            margin-top: 20px;
            width: 90%;
            max-width: 800px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background: #007bff;
            color: white;
        }
        .btn-sm {
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }
        .btn-warning { background: #ffc107; color: black; }
        .btn-danger { background: #dc3545; color: white; }
        .alert {
            background: #d4edda;
            color: #155724;
            padding: 10px;
            margin-top: 15px;
            border-radius: 4px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registrar Producto</h2>
        <form method="post" action="ControladorProducto">
            <div class="form-group">
                <label>Nombre</label>
                <input type="text" name="nombre" required>
            </div>
            <div class="form-group">
                <label>Precio Venta</label>
                <input type="text" name="preVenta" required>
            </div>
            <div class="form-group">
                <label>Precio Compra</label>
                <input type="text" name="preCompra" required>
            </div>
            <div class="form-group">
                <label>Estado</label>
                <input type="text" name="estado" required>
            </div>
            <div class="form-group">
                <label>Descripción</label>
                <input type="text" name="descripcion" required>
            </div>
            <button type="submit" class="btn">Registrar</button>
        </form>
    </div>
    
    <% String mensaje = (String) request.getAttribute("mensaje"); %>
    <% if (mensaje != null) { %>
        <div class="alert"><%= mensaje %></div>
    <% } %>
    
    <div class="table-container">
        <h2>Listado de Productos</h2>
        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Precio Venta</th>
                    <th>Precio Compra</th>
                    <th>Estado</th>
                    <th>Descripción</th>
                    <th colspan="2">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% List<TblProductosusti> listadoproductos = (List<TblProductosusti>) request.getAttribute("listado"); %>
                <% if (listadoproductos != null) { %>
                    <% for (TblProductosusti prod : listadoproductos) { %>
                        <tr>
                            <td><%= prod.getIdproductosusti() %></td>
                            <td><%= prod.getNombresusti() %></td>
                            <td><%= prod.getPrecioventasusti() %></td>
                            <td><%= prod.getPreciocompsusti() %></td>
                            <td><%= prod.getEstadosusti() %></td>
                            <td><%= prod.getDescripsusti() %></td>
                            <td>
                                <a href="ControladorProducto?accion=Modificar&cod=<%= prod.getIdproductosusti() %>" class="btn-sm btn-warning">Actualizar</a>
                            </td>
                            <td>
                                <a href="ControladorProducto?accion=Eliminar&cod=<%= prod.getIdproductosusti() %>" class="btn-sm btn-danger">Eliminar</a>
                            </td>
                        </tr>
                    <% } %>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
