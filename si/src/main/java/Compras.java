import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Compras {
    private int codigoCompra;
    private LocalDate fechaRealizacion;
    private MetodoPago metodoPago;
    private String productoComprado;
    private int valorTotal;
    private List<Producto> productos = new ArrayList<>();
    private boolean confirmada = false;
    private Clientes cliente;

    public Compras (int codigoCompra, LocalDate fechaRealizacion, MetodoPago metodoPago, String productoComprado, int valorTotal){
        this.codigoCompra= codigoCompra;
        this.fechaRealizacion= fechaRealizacion;
        this.metodoPago= metodoPago;
        this.productoComprado= productoComprado;
        this.valorTotal=valorTotal;
    }
    //Metodo para agregar un producto
    public boolean agregarProducto(Producto producto) {
        boolean agregado = false;
        if (producto.getCantidadDisponible() > 0) {
            int vecesEnCarrito = 0;
            for (int i = 0; i < productos.size(); i++) {
                Producto productoEnCarrito = productos.get(i);
                if (productoEnCarrito.getCodigoProducto() == producto.getCodigoProducto()) {
                    vecesEnCarrito = vecesEnCarrito + 1;
                }
            }
            if (vecesEnCarrito < producto.getCantidadDisponible()) {
                productos.add(producto);
                agregado = true;
            }
        }
        return agregado;
    }

    //Metodo para calcular el valor total
    public int calcularValorTotal() {
        int total = 0;
        for (int i = 0; i < productos.size(); i++) {
            Producto productoActual = productos.get(i);
            total = total + productoActual.getPrecioUnitario();
        }
        this.valorTotal = total;
        return total;
    }

    //Metodo para confirmar la compra
    public boolean confirmarCompra() {
        boolean esConfirmada = false;
        if (confirmada == false && productos.size() > 0) {
            for (int i = 0; i < productos.size(); i++) {
                Producto productoActual = productos.get(i);
                int stockActual = productoActual.getCantidadDisponible();
                productoActual.setCantidadDisponible(stockActual - 1);
            }
            confirmada = true;
            esConfirmada = true;
        }
        return esConfirmada;
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

    public boolean isConfirmada() {
        return confirmada;
    }

    @Override
    public String toString() {
        return "Compras{" +
                "codigoCompra=" + codigoCompra +
                ", fechaRealizacion=" + fechaRealizacion +
                ", metodoPago=" + metodoPago +
                ", productoComprado='" + productoComprado + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
}