package controllers;

import classes.Ingredientes;
import java.sql.SQLException;
import models.ModeloIngredientes;

public class ControladorIngredientes {
        public String getListadoIngredientes() throws SQLException{
        ModeloIngredientes ming = new ModeloIngredientes();
        String htmlcode = "";       
        for(Ingredientes ingredientes : ming.getListIngredientes()){
            htmlcode += "<tr>\n" +
"                             <th scope=\"row\">"+ingredientes.getCodigo()+"</th>\n" +
"                             <td>"+ingredientes.getNombre()+"</td>\n" +
"                             <td>"+ingredientes.getCantidad()+"</td>\n" +
"                             <td>"+ingredientes.getEstado()+"</td>\n" +
"                             <td>"+ingredientes.getRut()+"</td>\n" +     
"                             <td><a href='FormularioUpdateIngrediente.jsp?id="+ingredientes.getCodigo()+"&nombre="+ingredientes.getNombre()+"&cantidad="+ingredientes.getCantidad()+"&rut="+ingredientes.getRut()+"'>Modificar</a><br><br><form action='BorrarIngrediente' method='post'><input type='text' name='hidden' style='display:none;' value='"+ingredientes.getCodigo()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
}
