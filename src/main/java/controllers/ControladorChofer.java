/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Chofer;
import java.sql.SQLException;
import models.ModeloChofer;

/**
 *
 * @author Nicolas_Herrera
 */
public class ControladorChofer {
    //Mantenedor
    public String getDatosChofer() throws SQLException{
        ModeloChofer mc = new ModeloChofer();
        String htmlcode = "";       
        for(Chofer chofer : mc.getAllChofer()){
            htmlcode += "<tr>\n" +
"                             <th scope=\"row\">"+chofer.getRut()+"</th>\n" +
"                             <td>"+chofer.getNombre()+"</td>\n" +
"                             <td>"+chofer.getFono()+"</td>\n" +
"                             <td>"+chofer.getMail()+"</td>\n" +
"                             <td>"+chofer.getDireccion()+"</td>\n" +
"                             <td>"+chofer.getEstado()+"</td>\n" +                    
"                             <td><a href='FormularioUpdateChofer.jsp?rut="+chofer.getRut()+"&nombre="+chofer.getNombre()+"&fono="+chofer.getFono()+"&mail="+chofer.getMail()+"&direccion="+chofer.getDireccion()+"'>Modificar</a><br><br><form action='BorrarChofer' method='post'><input type='text' name='hidden' style='display:none;' value='"+chofer.getRut()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
  
}
