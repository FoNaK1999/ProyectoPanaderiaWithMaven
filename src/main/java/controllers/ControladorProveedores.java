package controllers;

import classes.Proveedor;
import classes.Usuarios;
import java.sql.SQLException;
import models.Conexion;
import models.ModeloProveedor;
import models.ModeloUsuarios;

public class ControladorProveedores extends Conexion {
       public String getListadoProveedores() throws SQLException{
        ModeloProveedor mprov = new ModeloProveedor();
        String htmlcode = "";       
        for(Proveedor proveedor : mprov.getListProveedor()){
            htmlcode += "<tr>\n" +
"                             <th scope=\"row\">"+proveedor.getRut()+"</th>\n" +
"                             <td>"+proveedor.getNombre()+"</td>\n" +
"                             <td>"+proveedor.getNombreEmpresa()+"</td>\n" +
"                             <td>"+proveedor.getDireccion()+"</td>\n" +
"                             <td>"+proveedor.getTelefono()+"</td>\n" +
"                             <td>"+proveedor.getEmail()+"</td>\n" +
"                             <td>"+proveedor.getEstado()+"</td>\n" +                    
"                             <td><a href='FormularioUpdateProveedor.jsp?id="+proveedor.getRut()+"&nombre="+proveedor.getNombre()+"&empresa="+proveedor.getNombreEmpresa()+"&fono="+proveedor.getTelefono()+"&Ubicacion="+proveedor.getDireccion()+"&email="+proveedor.getEmail()+"'>Modificar</a><br><br><form action='BorrarProveedor' method='post'><input type='text' name='hidden' style='display:none;' value='"+proveedor.getRut()+"'><input type='submit' value='Eliminar'></form></td>\n" +
"                       </tr>";
        }        
        return htmlcode;        
    }
       
    public String getRutProveedor() throws SQLException{
        ModeloProveedor mprov = new ModeloProveedor();
        String htmlcode = "";           
        for(Proveedor proveedor : mprov.getListProveedor()){
            htmlcode +="<option value="+proveedor.getRut()+">"+proveedor.getNombre()+"</option>";
        }        
        return htmlcode;        
    }

    
}
