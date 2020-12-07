<%@page import="classes.Producto"%>
<%@page import="controllers.ControladorProducto"%>
<%@page import="classes.Session"%>
<%@page import="classes.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(true);
    ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
    int rows = articulos.size();
    int valor = Integer.parseInt(request.getParameter("valor"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="servletsolicita" method="post" id="solicita" >
            <input type="hidden" name="rows" value="<%=rows%>">
            <input type="hidden" name="idped" value="<%=valor%>">
        </form>
        <script>
            document.getElementById('solicita').submit();
        </script>
    </body>
</html>
