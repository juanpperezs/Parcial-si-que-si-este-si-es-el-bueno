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