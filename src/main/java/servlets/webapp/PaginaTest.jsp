<%-- 
    Document   : PaginaTest
    Created on : 14-may-2020, 16:58:58
    Author     : Martin
--%>
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
                                                    if(articulos != null){
                                                    for(Articulo a: articulos){
                                                        Producto producto = cp.getProducto(a.getIdProducto());
                                                        total += a.getCantidad() * producto.getPrecio();                                                                                                                                                                
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
				</table>
                                        <input type="submit" value="Insertar pago a bd">
                                 </form>       
                                <% if (articulos == null){%>
                                <h4>No hay Articulos en el carro</h4>
                                <%}%>
                                <a class="btn btn-default check_out" href="pago.jsp?total=<%= total%>">PAGAR</a>
        <script src="js/carrito.js"></script>
    </body>
</html>
