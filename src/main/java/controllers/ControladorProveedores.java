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
"                             <td class=\"column1\">"+proveedor.getRut()+"</>\n" +
"                             <td class=\"column1\">"+proveedor.getNombre()+"</td>\n" +
"                             <td class=\"column1\">"+proveedor.getNombreEmpresa()+"</td>\n" +
"                             <td class=\"column1\">"+proveedor.getDireccion()+"</td>\n" +
"                             <td class=\"column1\">"+proveedor.getTelefono()+"</td>\n" +
"                             <td class=\"column1\">"+proveedor.getEmail()+"</td>\n" +
"                             <td class=\"column1\">"+proveedor.getEstado()+"</td>\n" +                    
"                             <td class=\"column1\"><a href='FormularioUpdateProveedor.jsp?id="+proveedor.getRut()+"&nombre="+proveedor.getNombre()+"&empresa="+proveedor.getNombreEmpresa()+"&fono="+proveedor.getTelefono()+"&Ubicacion="+proveedor.getDireccion()+"&email="+proveedor.getEmail()+"'>Modificar</a><br><br><form action='BorrarProveedor' method='post'><input type='text' name='hidden' style='display:none;' value='"+proveedor.getRut()+"'><input type='submit' value='Eliminar'></form></td>\n" +
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
