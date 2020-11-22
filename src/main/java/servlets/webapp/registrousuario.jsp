<%-- 
    Document   : registrousuario
    Created on : 28-may-2020, 14:30:57
    Author     : Nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            <!--Inicio de estilos para el login-->
    <style>
        
        table
        {
           border: 2px dotted black; 
           width: 25%;
        }
        input[type=text], input[type=password], input[type=email]
        {
            width: 100%;
            padding: 8px 20px;
            border: 2px solid black;
            box-sizing: border-box;
            margin:1px;
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
        input [type=submit]
        {
            border:solid;
            cursor: pointer;
            width: 40%;
        } 
        select
        {
            width: 100%;
            padding: 8px 20px;
            border: 2px solid black;
            box-sizing: border-box;
        }
    </style>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Registro</title>
        <link href="css/mstye.css" rel="stylesheet" type="text/css"/>
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
               <a class="navbar-brand" href="index.html"></a>
               <div class="rlogo"> 
                   <img src="img/logo022.png" alt="" width="110" height="100">
               </div>
            </div>
          </nav>
           <center><form method="post" action="">
                <table>
                    <tr><td colspan="2"><label>Ingrese Datos</label></td></tr>
                    <tr><td align="center" rowspan="2"><label1>R.U.T:</label1></td></tr>
                    <tr><td><input type="text" name="rut" required/></td></tr>
                    <tr><td align="center" rowspan="2"><label1>Nombre:</label1></td></tr>
                    <tr><td><input type="text" name="nameusu" required/></td></tr>
                    <tr><td align="center" rowspan="2"><label1>Contaseña:</label1></td></tr>
                    <tr><td><input type="password" name="passusu" required/></td></tr>
                    <tr><td align="center" rowspan="2"><label1>Validar Contaseña:</label1></td></tr>
                    <tr><td><input type="password" name="valpassusu" required/></td></tr>
                    <tr><td align="center" rowspan="2"><label1>Telefono:</label1></td></tr>
                    <tr><td><input type="text" name="phoneusu" required/></td></tr>
                    <tr><td align="center" rowspan="2"><label1>E-Mail:</label1></td></tr>
                    <tr><td><input type="email" name="mailusu" required/></td></tr>
                    <tr><td align="center" rowspan="2"><label1>Ubicacion:</label1></td></tr>
                    <tr><td><input type="text" name="ubiusu" required/></td></tr>
                    <!--Boton-->
                   <tr><td colspan="2" style="text-align:center;">
                            <input type="submit" value="Ingresar"/></td></tr>
                </table>
           </form></center>
    </body>
</html>
