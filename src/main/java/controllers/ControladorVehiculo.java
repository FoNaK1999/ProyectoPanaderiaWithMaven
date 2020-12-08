/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Chofer;
import classes.vehiculo;
import java.sql.SQLException;
import models.ModeloChofer;
import models.ModeloVehiculo;
/**
 *
 * @author marti
 */
public class ControladorVehiculo {
    public String getDatosVehiculo() throws SQLException{
        ModeloVehiculo mv = new ModeloVehiculo();
        String htmlcode = "";       
        for(vehiculo auto : mv.getAllAuto()){
            htmlcode += "<tr>\n" +
"                             <th scope=\"row\">"+auto.getMatricula()+"</th>\n" +
"                             <td>"+auto.getRut_chofer()+"</td>\n" +
"                             <td>"+auto.getEstado()+"</td>\n" +
"                             <td><a href='formularioUpdateVehiculo.jsp?matricula="+auto.getMatricula()+"&estado="+auto.getRut_chofer()+"&rutchofer="+auto.getEstado()+"'>Modificar</a><br><br><form action='BorrarVehiculo' method='post'><input type='text' name='hidden' style='display:none;' value='"+auto.getMatricula()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
    /*Esto va con Ingresar Vehiculo*/
     public String getRutChofer() throws SQLException{
        ModeloChofer mc = new ModeloChofer();
        String htmlcode = "";       
        for(Chofer chofer : mc.getAllChofer()){
            htmlcode +="<option value="+chofer.getRut()+">"+chofer.getNombre()+"</option>";
        }        
        return htmlcode;        
    }
}
