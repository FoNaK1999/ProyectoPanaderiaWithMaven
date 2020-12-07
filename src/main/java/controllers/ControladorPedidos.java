package controllers;

import classes.Pedido;
import classes.Producto;
import java.sql.SQLException;
import models.ModeloPedidos;
import models.ModeloProducto;

public class ControladorPedidos {
    
    public String getPedidos() throws SQLException{
        ModeloPedidos mp = new ModeloPedidos();
        String htmlcode = "";       
        for(Pedido pedido : mp.getListPedidos()){
            htmlcode += "<tr>\n" +
"                  <th scope=\"row\">"+pedido.getId()+"</th>\n" +
"                       <td>"+pedido.getFecha()+"</td>\n" +
"                       <td>"+pedido.getRutcliente()+"</td>\n" +
"                       <td>"+pedido.getEstado()+"</td>\n" +
"                       <td>"+pedido.getMatricula()+"</td>\n" + 
"                       <td><a href='FormularioUpdatePedido.jsp?id="+pedido.getId()+"&fecha="+pedido.getFecha()+"&rutcliente="+pedido.getRutcliente()+"&estado="+pedido.getEstado()+"&matricula="+pedido.getMatricula()+"'>Modificar</a><br><br><form action='BorrarPedido' method='post'><input type='text' name='hidden' style='display:none;' value='"+pedido.getId()+"'><input type='submit' value='Eliminar'></form></td>\n" +                    
"                  </tr>";
        }        
        return htmlcode;        
    }    
    
    
    
}
