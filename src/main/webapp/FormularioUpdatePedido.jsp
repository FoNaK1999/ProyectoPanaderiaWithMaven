<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String rut = request.getParameter("rut");
    String nombre = request.getParameter("nombre");
    String fono = request.getParameter("fono");
    String mail = request.getParameter("mail");
    String direccion = request.getParameter("direccion");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html" charset=UTF-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Conductor</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="img/panaderia1.png" type="image/png">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--<a class="navbar-brand container" href="#">Navbar</a>-->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!--Nabvar centro-->
                <a id="logo" class="navbar-brand" href="index.html"><img src="img/logo022.png" alt="" width="110" height="100"></a>
            </div>
        </nav>
    <center>
        <h1 align="center">Modificar Conductor</h1>
        <form action="UpdateChofer" method="post">
            <table>
                <tr><td colspan="2"><label>R.U.T conductor: </label></td></tr>
                <tr><td><input type="text" name="rut" value="<%=rut%>" required readonly="readonly"></td></tr>
                <tr><td colspan="2"><label>Nombre: </label></td></tr>
                <tr><td><input type="text" name="nombre" value="<%=nombre%>" required></td></tr>
                <tr><td colspan="2"><label>Telefono: </label></td></tr>
                <tr><td><input type="text" name="fono" value="<%=fono%>" required></td></tr>
                <tr><td colspan="2"><label>Correo Electronico </label></td></tr>
                <tr><td><input type="text" name="mail" value="<%=mail%>" required></td></tr>
                <tr><td colspan="2"><label>Direccion: </label></td></tr>
                <tr><td><input type="text" name="direccion" value="<%=direccion%>" required ></td></tr>
                <tr><td><label colspan="2">Cambiar estado:</label></td></tr>
                <tr><td><div id="content" style="padding:20px">
                            <label>Disponible</label>
                            <input type="radio"  name="state" value="Disponible" style="margin-right: 10px" required>
                            <label>No Disponible</label>
                            <input type="radio"  name="state" value="No Disponible" required>
                        </div></td></tr>
                <tr><td><input type="submit" value="Actualizar"/></td></tr>
            </table>
        </form>
        <a href="javascript:window.history.go(-1);" style="float:left; border:2px black solid; background-color:gainsboro;">Volver al listado</a>
    </center>
</body>
</html>
