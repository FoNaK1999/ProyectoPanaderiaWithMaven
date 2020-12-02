<%@page import="classes.Producto"%>
<%@page import="classes.Session"%>
<%@page import="classes.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.ControladorProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession misession= (HttpSession) request.getSession();
    Session miusuario= (Session) misession.getAttribute("usuario"); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
        
        <form action="ServletFactura2" method="post" id="pedido">
            <input type="hidden"  name="rut" value="<%=miusuario.getId()%>">
            <input type="hidden"  name="patente" value="FS12RT">
        </form>
            
        <script>
            document.getElementById('pedido').submit();
        </script>
    </body>
</html>
