/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import classes.Chofer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloChofer extends Conexion {
    
    public ArrayList<Chofer> getAllChofer() throws SQLException{
        ArrayList<Chofer> chofer = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String sql = "Select * from chofer";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                chofer.add(new Chofer(rs.getString("rut_ch"),rs.getString("nombre_ch"),rs.getString("fono_ch"),rs.getString("mail_ch"),rs.getString("estado_ch"),rs.getString("direccion_ch")));
            }
        }catch(Exception e){
            System.out.println("Error al obtener choferes");
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
        return chofer;
    }
    
    public boolean RegistrarChofer(String rut, String nombre, String fono, String email, String estado, String direccion){
        PreparedStatement pst = null;
        try{
            String sql = "insert into chofer (rut_ch,nombre_ch,fono_ch,mail_ch,estado_ch,direccion_ch) values (?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, rut);
            pst.setString(2, nombre);
            pst.setString(3, fono);
            pst.setString(4, email);
            pst.setString(5, estado);
            pst.setString(6, direccion);
            pst.executeUpdate();
            
            if(pst != null){
                return true;
            }
            
        }catch(SQLException ex){
            System.out.println("Error al insertar chofer");
        }finally{
            try{
                if(getConnection() != null){
                    getConnection().close();
                }
                if(pst != null){
                    pst.close();
                }
            }catch(Exception ex){
                
            }
        }
        return false;                               
    }
    
    public boolean UpdateChofer(String rut, String nombre, String fono, String email, String estado, String direccion){        
        PreparedStatement pst = null;
        try{
        String sql = "update chofer set nombre_ch = ? , fono_ch = ? , mail_ch = ? , estado_ch= ?, direccion_ch = ? where rut_ch = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, fono);
        pst.setString(3, email );
        pst.setString(4, estado);
        pst.setString(5, direccion);
        pst.setString(6, rut);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al actualizar chofer");
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
    
    public boolean BorrarChofer(String rut){
        PreparedStatement pst = null;
        try{
        String sql = "update chofer set estado_ch = 'Eliminado' where rut_ch = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, rut);
        pst.executeUpdate();
        return true;
        }catch(Exception ex){
            System.out.println("Error al eliminar chofer");
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