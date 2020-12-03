<%@page import="com.transbank.webpay.wswebpay.service.WsTransactionDetailOutput"%>
<%@page import="com.transbank.webpay.wswebpay.service.WsTransactionDetailOutput"%>
<%@page import="com.transbank.webpay.wswebpay.service.TransactionResultOutput"%>
<%@page import="java.util.Random"%>
<%@page import="com.transbank.webpay.wswebpay.service.WsInitTransactionOutput"%>
<%@page import="cl.transbank.webpay.WebpayNormal"%>
<%@page import="models.bank"%>
<%@page import="classes.Producto"%>
<%@page import="classes.Session"%>
<%@page import="classes.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.ControladorProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(true);
    ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
    HttpSession misession= (HttpSession) request.getSession();
    Session miusuario= (Session) misession.getAttribute("usuario");
    
     String tipopago="hola";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
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
            }
          }
        %>                
        <form action="ServletFactura2" method="post" id="pedido">
            <input type="hidden" name="rut" value="<%=miusuario.getId()%>">
            <input type="hidden" name="patente" value="FS12RT">
            <input type="hidden" name="monto" value="<%=total%>">
            <input type="hidden" name="codeorder" id="codeorder" value="">
            <input type="hidden" name="tipopago" id="tipopago" value="">
        </form>
            
        <script>
            document.getElementById('tipopago').value = localStorage.getItem('tipopago');
            document.getElementById('codeorder').value = localStorage.getItem('codeorder');
            document.getElementById('pedido').submit();
        </script>
    </body>
</html>
