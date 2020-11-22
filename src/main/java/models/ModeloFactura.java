/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Articulo;
import classes.Pedido;
import classes.solicitar;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicolas
 */
 //Buscar factura
public class ModeloFactura extends Conexion{
   public int RegistrarPedido(String estado, String rutCliente, String matricula){
     PreparedStatement pst = null;
        ResultSet rs = null;
        int lastId=0;
        try{
                String sql = "insert into pedidos (fecha_ped, estado_ped, id_usu_ped, id_ve_ped) values (CURDATE(),?,?,?)";
                pst = getConnection().prepareStatement(sql);
                pst.setString(1, estado);
                pst.setString(2, rutCliente);
                pst.setString(3, matricula);
                pst.executeUpdate();            
                while(pst != null){
                    rs = pst.getGeneratedKeys(); 

                if (rs != null && rs.next()) { 
                       lastId = rs.getInt(1);
                       return lastId;
                }
                    
                }  
        }catch(SQLException ex){
            System.out.println("Error en los datos del pedido");
        }finally{
            try{
                if(getConnection() != null){
                    getConnection().close();
                }
                if(pst != null){
                    pst.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
                
            }
        }
        return lastId;
    }
   
    public boolean UpdateStock(int cantidad,int idprod){        
        PreparedStatement pst = null;
        try{
        String sql = "UPDATE productos set stock_producto = stock_producto - ? WHERE id_producto = ? ";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1,cantidad);
        pst.setInt(2, idprod);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al obtener producto");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
    
    public boolean RegistrarSolicitar(int idprod, int cantidad, int idped, int rows){        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        String sql = "insert into solicitar (cantidad_sol,id_producto_sol,id_ped_sol) values (?,?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1,cantidad);  
        pst.setInt(2,idprod);  
        pst.setInt(3,idped);  
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al obtener solicitud");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
    
    
    
    public boolean ObtenerVehiculo(){        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        String sql = "select * from vehiculo where estado_ve = 'Disponible'";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();      
        if(rs.absolute(1)){
            return true;
        }
        }catch(Exception ex){
            System.out.println("Error al obtener producto");
        }finally{
            try{
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
            }catch(Exception e){
                System.out.println("Error");
            }
        
        }
      return false;
    }
    
    public Pedido getPedido(){
        Pedido pedido = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "select * from pedidos)";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                pedido = new Pedido(rs.getInt("id_ped"), rs.getString("fecha_ped"),rs.getString("estado_ped"), rs.getString("id_usu_ped"), rs.getString("id_ve_ped"));
            }
        } catch (Exception e) {
            
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }       
        return pedido;
        
    }
    
    public static void main(String[] args){
       ModeloFactura mf = new ModeloFactura();
        System.out.println(mf.RegistrarPedido("Disponible", "12.123.123-1", "matritest"));
    }
}
 //Fin Buscar  factura

//UPDATE tabla productos stock_producto= stock_producto -'cantidad' WHERE id_producto='id'