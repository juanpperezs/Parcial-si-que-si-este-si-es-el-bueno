import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    //Set atributos
    private String nombreComercial;
    private String direccion;
    private int telefono;

    //Lista
    private List<Clientes>listaClientes;
    private List<Compras>listaCompras;
    private List<Producto>listaProductos;
    private List<ReporteVentas>listaReporteVentas;


    //Constructor
    public Supermercado(String nombreComercial, String direccion, int telefono) {
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;

        //Iniciar listas
        listaClientes= new ArrayList<>();
        listaCompras= new ArrayList<>();
        listaProductos= new ArrayList<>();
        listaReporteVentas= new ArrayList<>();
    }

    //=======Clientes=======

    //Metodo para verificar clientes
    public boolean verificarClientes(int documentoIdentidad) {
        boolean existe = false;
        for (Clientes clientes : listaClientes) {
            if (clientes.getDocumentoIdentidad() == documentoIdentidad) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Metodo para agregar clientes
    public boolean agregarClientes(Clientes clientes){
        boolean agregado= false;
        boolean existe= verificarClientes(clientes.getDocumentoIdentidad());
        if(existe==false){
            listaClientes.add(clientes);
            agregado= true;
        }
        return agregado;
    }

    //Metodo para actualizar datos de cliente
    public boolean actualizarCliente (int documento, Clientes clienteActualizado) {
        boolean estaActualizado = false;
        for (Clientes cliente : listaClientes) {
            if (cliente.getDocumentoIdentidad() == documento) {
                cliente.setDocumentoIdentidad(clienteActualizado.getDocumentoIdentidad());
                cliente.setNombreCompleto(clienteActualizado.getNombreCompleto());
                cliente.setTelefono(clienteActualizado.getTelefono());
                cliente.setCorreoElectronico(clienteActualizado.getCorreoElectronico());
                estaActualizado = true;
                break;
            }
        }
        return estaActualizado;
    }

    //Metodo para eliminar clientes
    public boolean eliminarCliente (int documentoIdentidad){
        boolean esEliminado=false;
        for (Clientes clientes: listaClientes){
            if(clientes.getDocumentoIdentidad()==documentoIdentidad){
                listaClientes.remove(clientes);
                esEliminado=true;
                break;
            }
        }
        return esEliminado;
    }

    //========Productos========

    //Metodo para verificar productos
    public boolean verificarProducto(int codigoProducto) {
        boolean existe = false;
        for (Producto producto : listaProductos) {
            if (producto.getCodigoProducto() == codigoProducto) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //Metodo para agregar productos
    public boolean agregarProducto(Producto producto){
        boolean agregado= false;
        boolean existe= verificarProducto(producto.getCodigoProducto());
        if(existe==false){
            listaProductos.add(producto);
            agregado= true;
        }
        return agregado;
    }

    //Metodo para actualizar productos
    public boolean actualizarProducto (int codigoProducto, Producto productoActualizado){
        boolean estaActualizado=false;
        for (Producto producto: listaProductos){
            if (producto.getCodigoProducto() == codigoProducto){
                producto.setNombreProducto(productoActualizado.getNombreProducto());
                producto.setPrecioUnitario(productoActualizado.getPrecioUnitario());
                producto.setCantidadDisponible(productoActualizado.getCantidadDisponible());
                estaActualizado=true;
                break;
            }
        }
        return estaActualizado;
    }

    //Getters y setters
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    //To string
    @Override
    public String toString() {
        return "Supermercado{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", listaClientes=" + listaClientes +
                ", listaCompras=" + listaCompras +
                ", listaProductos=" + listaProductos +
                ", listaReporteVentas=" + listaReporteVentas +
                '}';
    }
}