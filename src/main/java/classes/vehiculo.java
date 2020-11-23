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
public class vehiculo {
    private String matricula;
    private String rut_chofer;
    private String estado;
    
    public vehiculo(String matricula, String rut_chofer,String estado) {
        this.matricula  = matricula;
        this.rut_chofer = rut_chofer;
        this.estado = estado;
    }    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getRut_chofer() {
        return rut_chofer;
    }

    public void setRut_chofer(String rut_chofer) {
        this.rut_chofer = rut_chofer;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
