<%@page import="controllers.ControladorIngredientes"%>
<%
    ControladorIngredientes ci = new ControladorIngredientes();
    String status = request.getParameter("status");
    String code = "<script>alert('Hola');</script>";
%>
<!DOCTYPE html>
<html>
    <head>
	<title>Ingredientes</title>
	<meta http-equiv="Content-type" content="text/html" charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main2.css">
<!--===============================================================================================-->
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <!--<a class="navbar-brand container" href="#">Navbar</a>-->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!--Navbar izquierdo-->
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="index.html">Casa</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="IngresarIngrediente.jsp">Ingresar Ingrediente</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="mantenedorProveedores.jsp">Mantenedor Proveedores</a>
                </li>
              </ul>
                <!--Nabvar centro-->
                <a class="navbar-brand" href="index.html"><img src="img/logo022.png" alt="" width="110" height="100"></a>
                <!--Navbar derecho-->
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="javascript:window.history.go(-1);">Volver</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#"></a>
                </li>
              </ul>
            </div>
          </nav>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">CODIGO</th>
								<th class="column1">NOMBRE</th>
								<th class="column1">CANTIDAD</th>
								<th class="column1">ESTADO</th>
                                                                <th class="column1">RUT PROVEEDOR</th>
                                                                <th class="column1">ACCIONES</th>
							</tr>
						</thead>
						<tbody>
                                                    <%=ci.getListadoIngredientes()%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
                    <%
                    if(status=="2"){
                    %>
                    <script>alert("No se ha podido guardar los cambios")</script>
                    <%
                    }else if(status=="1"){
                    %>
                    <script>alert("Guardado con exito")</script>
                    <%
                    }else{    
                    %>
                    
                    <%
                    }  
                    %>
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
        
    </body>
</html>
