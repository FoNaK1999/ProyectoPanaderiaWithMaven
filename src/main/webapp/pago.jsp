<%@page import="java.util.List"%>
<%@page import="com.transbank.webpay.wswebpay.service.WsInitTransactionOutput"%>
<%@page import="java.util.Random"%>
<%@page import="cl.transbank.webpay.WebpayNormal"%>
<%@page import="models.bank"%>
<%@page import="classes.Producto"%>
<%@page import="controllers.ControladorProducto"%>
<%@page import="classes.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page import="classes.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
     HttpSession sesion = request.getSession(true);
     ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
     HttpSession misession= (HttpSession) request.getSession();
     Session miusuario= (Session) misession.getAttribute("usuario");
     
    bank b = new bank();
    
    WebpayNormal transaction = b.calltransaction();
    String totalventa = request.getParameter("total");
    // ...
    double amount = Double.parseDouble(totalventa);
    
    // Identificador que será retornado en el callback de resultado:
    String sessionId = "mi-id-de-sesion";
    // Identificador único de orden de compra:
    String buyOrder = String.valueOf(Math.abs(new Random().nextLong()));
    String returnUrl = "http://localhost:8080/PananderiaProject/return.jsp";
    String finalUrl = "http://localhost:8080/PananderiaProject/final.jsp";
    WsInitTransactionOutput initResult = transaction.initTransaction(
            amount, sessionId, buyOrder, returnUrl, finalUrl);

    String formAction = initResult.getUrl();
    String tokenWs = initResult.getToken();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->   
    <link href="css/popupstyle.css" rel="stylesheet" >
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <script src="js/popupfunction.js" type="text/javascript"></script>
        <title>Pagina Test</title>
    </head>
    <body>
        	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
			</div>
			<div class="table-responsive cart_info" id="cart-container">
                            <table class="table table-condensed" id="shop-table">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            
                                            
                                                <%
                                                    ControladorProducto cp = new ControladorProducto();
                                                    int total = 0;
                                                    String htmlcode = "";
                                                    if(articulos != null){
                                                    for(Articulo a: articulos){
                                                        Producto producto = cp.getProducto(a.getIdProducto());
                                                        total += a.getCantidad() * producto.getPrecio();                                                                                                                                                                
                                                %>
                                                
                                                <%
                                                    htmlcode += "<input type='text' name='idprod' value='"+a.getIdProducto()+"'>\n"+"<input type='text' name='cantidad' value='"+a.getCantidad()+"'>";                                            
                                                %>
                                                
                                                
                                                
                                        
                                                
                                        <form action="test" method="post">
						<tr>
							<td class="cart_product">
                                                            <a href=""><img src="<%= producto.getImg()%>" alt="" width="120"></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><%= producto.getNombre()%></a></h4>
								<p >Web ID: <%= producto.getId()%></p>
                                                                <input type="text" value="<%= producto.getId()%>" name="productoid" style="display:none;">
                                                                <input type="text" value="<%=a.getCantidad() * producto.getPrecio()%>" name="totalventa" style="display:none;">
                                                                <input type="text" value="<%=miusuario.getId()%>" name="rut" style="display:none;">
							</td>
							<td class="cart_price">
								<p>$<%= producto.getPrecio()%></p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<!--<a class="cart_quantity_up" href=""> + </a>-->
                                                                        <input class="cart_quantity_input" type="text" name="quantity" value="<%= a.getCantidad()%>" autocomplete="off" size="2" readonly="readonly">
									<!--<a class="cart_quantity_down" href=""> - </a>-->
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price" >$<%=a.getCantidad() * producto.getPrecio()%></p>
							</td>
							<td class="cart_delete">
                                                            <span id="idarticulo" style="display:none;"><%= producto.getId()%></span>
                                                            <!--<a class="cart_quantity_delete" href="" id="deleteitem"><i class="fa fa-times"></i></a>-->
							</td>
						</tr>
                                            
                                                <%}}%>
					</tbody>
                                        <h1><%=htmlcode%></h1>
				</table>
                                        <!--<input type="submit" value="Insertar pago a bd">-->
                                 </form>       
                                <% if (articulos == null){%>
                                <h4>No hay Articulos en el carro</h4>
                                <%}%>
                                <form action="<%=formAction%>" method="post">
                                    <label>Monto: <input type="text" id="Name" name="Name" value="<%=amount%>" readonly/></label>
                                    <input type="hidden" name="token_ws" value="<%=tokenWs%>">
                                    <input type="submit" class="btn btn-default check_out" value="PAGAR">
                                </form>
                                
                </section>
    <style>
        
        table
        {
           border: 2px dotted black; 
           width: 25%;
        }
        input[type=text]
        {
            width: 75%;
            padding: 8px 20px;
            border: 2px solid black;
            box-sizing: border-box;
        }
        label{
            font-size:30px;
            font-family: Arial;
            font-weight: bold;
        }
        label1{
            font-size:14px;
            font-family: Arial;
            font-weight: bold;
        }
        input[type=submit]
        {
            border:solid;
            cursor: pointer;
            width: 40%;
        } 
        select
        {
            width: 75%;
            padding: 8px 20px;
            border: 2px solid black;
            box-sizing: border-box;
        }
        p{
            
            width: 75%;
            padding: 8px 20px;
            box-sizing: border-box;
        }
    </style>
        <!--<table>
                   
                    <!--Para la pagina de pago
                    <tr><td colspan="2"><label>Ingrese datos</label></td></tr>
                    <tr><td align="center" rowspan="2"><label1>Tipo de pago:</label1></td></tr>
                    <tr><td><select name="etp" style="margin: 10px;" required>
                    <option value="" disable selected>Selecciona una opción</option>                               
                    <option value="Credito">Credito</option>
                    <option value="Debito">Debito</option>
                    <option value="Efectivo">Efectivo</option>
                    </select></td></tr>
                    <input type="text" name="total" value="" style="display: none;">
                    <!--Boton
                    <tr><td colspan="2" style="text-align:center;">
                            <input type="submit" value="Aceptar"/></td></tr>
        </table>-->
        <script src="js/carrito.js"></script>
    </body>
</html>
