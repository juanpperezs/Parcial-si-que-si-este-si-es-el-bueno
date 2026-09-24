public class Producto {

    //Atributos
    private int codigoProducto;
    private String nombreProducto;
    private int precioUnitario;
    private int cantidadDisponible;

    //Relación de Producto con categoria
    private Categoria categoria;

    //Constructor
    public Producto(int codigoProducto, String nombreProducto, int precioUnitario, int cantidadDisponible, Categoria categoria) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
        this.categoria = categoria;
    }

    //Getters y Setters
    public int getCodigoProducto() {
        return codigoProducto;
    }
    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoProducto=" + codigoProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", cantidadDisponible=" + cantidadDisponible +
                ", categoria=" + categoria +
                '}';
    }
}
