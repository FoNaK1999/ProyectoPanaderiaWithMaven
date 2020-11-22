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
        <%
            ControladorProducto cp = new ControladorProducto();
            int total = 0;
            String htmlcode = "";
            if(articulos != null){
            for(Articulo a: articulos){
                Producto producto = cp.getProducto(a.getIdProducto());
                total += a.getCantidad() * producto.getPrecio();                                                                                                                                                                
                htmlcode += "<input type='text' name='idprod' value='"+a.getIdProducto()+"'>\n"+"<input type='text' name='cantidad' value='"+a.getCantidad()+"'>";
            }
          }
        %>
        <form action="servletsolicita" method="post" id="solicita" >
            <input type="text" name="rows" value="<%=rows%>">
            <input type="text" name="idped" value="<%=valor%>">
        </form>
        <script>
            document.getElementById('solicita').submit();
        </script>
    </body>
</html>
