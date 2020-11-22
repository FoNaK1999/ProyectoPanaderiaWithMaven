/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author marti
 */
public class Usuarios {
    private String id;
    private String nombre;
    private String apellido;
    private String fono;
    private String ubicacion;
    private String mail;
    private String pass;
    private String estado;

    
    public Usuarios(String id,String nombre, String apellido,String fono,String ubicacion, String mail, String pass, String estado){
        this.id = id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.fono = fono;
        this.ubicacion = ubicacion;
        this.mail = mail;
        this.pass = pass;
        this.estado = estado;

    }
    
    public Usuarios(){
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getFono(){
        return fono;
    }
    
    public void setFono(String fono){
        this.fono = fono;
    }
    
    public String getUbicacion(){
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
