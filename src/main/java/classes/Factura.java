/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Nicolas
 */
public class Factura {
    private int id;
    private int total;
    private String detalle;
   
    
    public Factura(int id, int total, String detalle){
        this.id = id;
        this.total = total;
        this.detalle = detalle;
    }
    public Factura(){

    }   
    public int getId(){
        return id;
    }
    public void setId(){
         this.id = id;
    }
    public int getTotal(){
        return total;
    }
    public void setTotal(){
         this.total = total;
    }
    public String getDetalle(){
        return detalle;
    }
    public void setDetallel(){
         this.detalle = detalle;
    }

}
