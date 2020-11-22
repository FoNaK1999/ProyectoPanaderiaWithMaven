package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String user="root";
    private String pass="";
    private String port="3306";
    private String host="localhost";
    private String database="bakerynico3";
    private String classname="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://"+host+":"+port+"/"+database;
    Connection con;
    
    public Conexion(){
        try{
            Class.forName(classname);
            con = DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            System.out.println("Error en la conexion"+ e);
        }
    }
    public Connection getConnection(){
        return this.con;
    }
}   
