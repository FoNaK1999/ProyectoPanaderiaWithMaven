/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Proveedor;
import classes.Venta;
import java.sql.SQLException;
import models.ModeloPedidos;
import models.ModeloProveedor;

/**
 *
 * @author marti
 */
public class ControladorFactura {
    public String getListadoVenta() throws SQLException{
        ModeloPedidos mp = new ModeloPedidos();
        String htmlcode = "";     
        for(Venta venta : mp.getListVenta()){
            htmlcode += "<tr>\n" +
"           <button type=\"button\" class=\"list-group-item list-group-item-action\" disabled >Metodo de Pago:  "+venta.getTipopago()+"</button>\n"+
"           <button type=\"button\" class=\"list-group-item list-group-item-action\" disabled >Fecha:  "+venta.getFecha()+"</button>\n";                  
        }        
        return htmlcode;        
    }
}
