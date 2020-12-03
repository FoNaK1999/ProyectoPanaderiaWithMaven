package classes;

public class Venta {
    private String id;
    private String fecha;
    private int total;
    private String tipopago;
    private String estado;
    private int idped;
    
    public Venta(String id, String fecha, int total, String tipopago, String estado, int idped ){
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.tipopago = tipopago;
        this.estado = estado;
        this.idped = idped;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdped() {
        return idped;
    }

    public void setIdped(int idped) {
        this.idped = idped;
    }
    
    
    
}
