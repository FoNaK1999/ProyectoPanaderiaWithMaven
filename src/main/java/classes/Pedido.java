package classes;

public class Pedido {
    private int id;
    private String fecha;
    private String estado;
    private String rutcliente;
    private String matricula;
    
    public Pedido(int id, String fecha, String estado, String rutcliente, String matricula){
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.rutcliente = rutcliente;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRutcliente() {
        return rutcliente;
    }

    public void setRutcliente(String rutcliente) {
        this.rutcliente = rutcliente;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}
