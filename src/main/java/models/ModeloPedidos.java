/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Pedido;
import classes.Proveedor;
import classes.Venta;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class ModeloPedidos extends Conexion {
    public int RegistrarPedido(String estado, String rutCliente, String matricula){
        PreparedStatement pst = null;
        ResultSet rs = null;
        int lastid = -1;
        
        System.out.println("Modelo: "+estado + rutCliente + matricula);
        
        try{
            
                String sql = "insert into pedidos (fecha_ped, estado_ped, id_usu_ped, id_ve_ped) values (CURDATE(),?,?,?)";
                pst = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                pst.setString(1,estado);
                pst.setString(2,rutCliente);
                pst.setString(3,matricula);
                System.out.println("Modelo TRY: "+estado +" "+ rutCliente +" "+ matricula);
                pst.executeUpdate();

                
                
                rs = pst.getGeneratedKeys();
                
                if (rs.next()){
                    lastid=rs.getInt(1);
                                
                }
                return lastid;
                
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
            }catch(SQLException ex){
                
            }
        }
        return lastid;
    }
   
    public boolean UpdateStock(int cantidad,int idprod){        
        PreparedStatement pst = null;
        
        System.out.println(cantidad+" "+idprod);
        
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
    //Insercion en tabla venta
    public boolean RegistrarVenta(String id, int total, String tipopago, String estado, int idped){        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        
        try{
        String sql = "insert into venta (id_v, fecha_v, total_v, tipopago_v, estado_dv, id_ped_v) values (?,CURDATE(),?,?,?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, id);
        pst.setInt(2, total);
        pst.setString(3, tipopago);
        pst.setString(4, estado);
        pst.setInt(5, idped);
        pst.executeUpdate();
        System.out.println(id+" "+total+" "+tipopago+" "+estado+" "+idped);
        return true;
        }catch(Exception ex){
            System.out.println("Error al registrar venta");
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
    
    public ArrayList<Venta> getListVenta() throws SQLException{
        ArrayList<Venta> venta = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from venta";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                venta.add(new Venta(rs.getString("id_v"),rs.getString("fecha_v"),rs.getInt("total_v"),rs.getString("tipopago_v"),rs.getString("estado_dv"),rs.getInt("id_ped_v")));
            }
        }catch(Exception e){
            System.out.println("Error");
        }finally{
            try{
                if(rs != null){
                    if(pst != null){
                        if(getConnection() != null){
                            getConnection().close();
                        }
                    }
                }
            }catch(Exception e){
                System.out.println("Error");
            }
        }
        return venta;
    }
    
    public static void main(String[] args){
       ModeloPedidos mf = new ModeloPedidos();
       int total = 1500;
       int idped = 66;
       mf.RegistrarVenta("1", total, "VN","Aprobado", idped);               
    }
}
