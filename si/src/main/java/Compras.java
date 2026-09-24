import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compras {
    private int codigoCompra;
    private LocalDate fechaRealizacion;
    private MetodoPago metodoPago;
    private String productoComprado;
    private int valorTotal;

    //Lista de compras realizadas
    private List<Compras> comprasRealizadas;

    public Compras (int codigoCompra, LocalDate fechaRealizacion, MetodoPago metodoPago, String productoComprado, int valorTotal){
        this.codigoCompra= codigoCompra;
        this.fechaRealizacion= fechaRealizacion;
        this.metodoPago= metodoPago;
        this.productoComprado= productoComprado;
        this.valorTotal=valorTotal;

        comprasRealizadas= new ArrayList<>();
    }


    //Getters y setters
    public int getCodigoCompra() {
        return codigoCompra;
    }
    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }
    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getProductoComprado() {
        return productoComprado;
    }
    public void setProductoComprado(String productoComprado) {
        this.productoComprado = productoComprado;
    }

    public int getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Compras> getComprasRealizadas() {return comprasRealizadas;}
    public void setComprasRealizadas(List<Compras> comprasRealizadas) {this.comprasRealizadas = comprasRealizadas;}

    @Override
    public String toString() {
        return "Compras{" +
                "codigoCompra=" + codigoCompra +
                ", fechaRealizacion=" + fechaRealizacion +
                ", metodoPago=" + metodoPago +
                ", productoComprado='" + productoComprado + '\'' +
                ", valorTotal=" + valorTotal +
                ", comprasRealizadas=" + comprasRealizadas +
                '}';
    }
}
