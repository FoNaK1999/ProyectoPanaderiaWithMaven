/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Nicolas_Herrera
 */
public class Chofer {
    private String rut;
    private String nombre;
    private String fono;
    private String mail;
    private String estado;
    private String direccion;
    
    public Chofer(String rut, String nombre,String fono, String mail, String estado, String direccion) {
        this.rut  = rut;
        this.nombre = nombre;
        this.fono = fono;
        this.mail = mail;
        this.estado = estado;
        this.direccion = direccion;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}

