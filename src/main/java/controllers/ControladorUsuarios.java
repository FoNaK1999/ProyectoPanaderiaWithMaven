package controllers;

import classes.Usuarios;
import java.sql.SQLException;
import models.ModeloUsuarios;

public class ControladorUsuarios {
    //Crear listado que se mostrara en mantenedor de usuarios
    public String getListadoUsuarios() throws SQLException{
        ModeloUsuarios mu = new ModeloUsuarios();
        String htmlcode = "";       
        for(Usuarios usuarios : mu.getListUsuarios()){
            htmlcode += "<tr>\n" +
"                             <th scope=\"row\">"+usuarios.getId()+"</>\n" +
"                             <td>"+usuarios.getNombre()+"</td>\n" +
"                             <td>"+usuarios.getApellido()+"</td>\n" +
"                             <td>"+usuarios.getFono()+"</td>\n" +
"                             <td>"+usuarios.getUbicacion()+"</td>\n" +
"                             <td>"+usuarios.getMail()+"</td>\n" +
"                             <td>"+usuarios.getPass()+"</td>\n" +
"                             <td>"+usuarios.getEstado()+"</td>\n" +
"                             <td><a href='FormularioUpdateUsuario.jsp?id="+usuarios.getId()+"&nombre="+usuarios.getNombre()+"&Apellido="+usuarios.getApellido()+"&fono="+usuarios.getFono()+"&Ubicacion="+usuarios.getUbicacion()+"&email="+usuarios.getMail()+"&pass="+usuarios.getPass()+"&estado="+usuarios.getEstado()+"'>Modificar</a><br><br><form action='BorrarUsuario' method='post'><input type='text' name='hidden' style='display:none;' value='"+usuarios.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
    
    
    
}
