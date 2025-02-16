<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Producto</title>
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
        .btn-container {
            display: flex;
            justify-content: space-between;
        }
        .btn {
            width: 48%;
            padding: 10px;
            text-align: center;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            transition: background 0.3s ease;
        }
        .btn-update {
            background: #007bff;
            color: white;
        }
        .btn-update:hover {
            background: #0056b3;
        }
        .btn-cancel {
            background: #dc3545;
            color: white;
            text-decoration: none;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .btn-cancel:hover {
            background: #c82333;
        }
        .message {
            margin-top: 15px;
            padding: 10px;
            background: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
            border-radius: 4px;
            text-align: center;
            display: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Actualizar Producto</h2>
        
        <% String mensaje = (String) request.getAttribute("mensaje"); %>
        <% if (mensaje != null) { %>
            <div class="message"><%= mensaje %></div>
        <% } %>
        
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
            
            <div class="form-group">
                <label>Nombre</label>
                <input type="text" name="nombre" value="<%= nombre %>" required>
            </div>
            <div class="form-group">
                <label>Precio de Venta</label>
                <input type="text" name="preVenta" value="<%= preVenta %>" required>
            </div>
            <div class="form-group">
                <label>Precio de Compra</label>
                <input type="text" name="preCompra" value="<%= preCompra %>" required>
            </div>
            <div class="form-group">
                <label>Estado</label>
                <input type="text" name="estado" value="<%= estado %>" required>
            </div>
            <div class="form-group">
                <label>Descripción</label>
                <input type="text" name="descripcion" value="<%= descripcion %>" required>
            </div>
            <div class="btn-container">
                <button type="submit" class="btn btn-update">Actualizar</button>
                <a href="ControladorProducto?accion=Listar" class="btn btn-cancel">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>
    