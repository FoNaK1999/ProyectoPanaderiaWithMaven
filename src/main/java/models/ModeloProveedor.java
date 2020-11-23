/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class ModeloProveedor extends Conexion {
    public ArrayList<Proveedor> getListProveedor() throws SQLException{
        ArrayList<Proveedor> proveedor = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "select * from proveedor";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                proveedor.add(new Proveedor(rs.getString("rut_prov"),rs.getString("nombre_prov"),rs.getString("empresa_prov"),rs.getString("direccion_prov"),rs.getString("telefono_prov"),rs.getString("email_prov"),rs.getString("estado_prov")));
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
        return proveedor;
    }
    
    public boolean RegistrarProveedor(String rut, String nombre, String nombreempresa, String direccion, String telefono, String email, String estado){
        PreparedStatement pst = null;
        try{
        String sql = "insert into proveedor (rut_prov,nombre_prov,empresa_prov,direccion_prov,telefono_prov,email_prov,estado_prov) values (?,?,?,?,?,?,?)";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, rut);
        pst.setString(2, nombre);
        pst.setString(3, nombreempresa);
        pst.setString(4, direccion);
        pst.setString(5, telefono);
        pst.setString(6, email);
        pst.setString(7, estado);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al insertar proveedor");
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
    
    public boolean UpdateProveedor(String rut, String nombre, String nombreempresa, String direccion, String telefono, String email, String estado){
        PreparedStatement pst = null;
        try{
        String sql = "update proveedor set nombre_prov = ?, empresa_prov = ?, direccion_prov = ?, telefono_prov = ?, email_prov = ?, estado_prov = ? where rut_prov = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, nombreempresa);
        pst.setString(3, direccion);
        pst.setString(4, telefono);
        pst.setString(5, email);
        pst.setString(6, estado);
        pst.setString(7, rut);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al modificar proveedor");
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
    
        public boolean BorrarProveedor(String rut){
        PreparedStatement pst = null;
        try{
        String sql = "update proveedor set estado_prov = 'Eliminado' where rut_prov = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, rut);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al eliminar proveedor");
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
        
        
    
}
