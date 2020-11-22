package classes;

public class solicitar {
    private int id;
    private int cantidad;
    private int idprod;
    private int idped;
    
    public solicitar(int id,int cantidad, int idprod, int idped){
        this.id = id;
        this.cantidad = cantidad;
        this.idprod=idprod;
        this.idped = idped;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public int getIdped() {
        return idped;
    }

    public void setIdped(int idped) {
        this.idped = idped;
    }
    
    
}
