<%@page import="classes.Producto"%>
<%@page import="classes.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.ControladorProducto"%>
<%@page import="classes.Articulo"%>
<%@page import="models.bank"%>
<%@page import="cl.transbank.webpay.WebpayNormal"%>
<%@page import="com.transbank.webpay.wswebpay.service.WsTransactionDetailOutput"%>
<%@page import="com.transbank.webpay.wswebpay.service.TransactionResultOutput"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(true);
    ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
    HttpSession misession= (HttpSession) request.getSession();
    Session miusuario= (Session) misession.getAttribute("usuario");
    
    
    
    bank b = new bank();
    
    WebpayNormal transaction = b.calltransaction();
    // ...
    String token_ws = request.getParameter("token_ws");
    
    TransactionResultOutput result =
        transaction.getTransactionResult(request.getParameter("token_ws"));
    WsTransactionDetailOutput output = result.getDetailOutput().get(0);
    

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%           
            if(output.getResponseCode()==0){ 
            
        %> 
        
        <script>localStorage.clear();</script>
        <script>localStorage.setItem("amount","<%=output.getAmount()%>");</script>
        <script>localStorage.setItem("codeorder","<%=output.getBuyOrder()%>");</script>
        <script>localStorage.setItem("tipopago","<%=output.getPaymentTypeCode()%>");</script>
                           
        <form action="<%=result.getUrlRedirection()%>" method="post" id="return-form">
            <input type="hidden" name="token_ws" value="<%=token_ws%>">
        </form>
        <script>
            document.getElementById('return-form').submit();
        </script>
        <%
         }
        %>
    </body>
</html>
