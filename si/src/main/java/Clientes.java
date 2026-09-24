import java.util.List;
import java.util.ArrayList;

public class Clientes {
    //Atributos
    private String nombreCompleto;
    private int documentoIdentidad;
    private int telefono;
    private String correoElectronico;

    //Lista de compras realizadas
    private List<Compras> comprasRealizadas;

    //Constructor
    public Clientes (String nombreCompleto, int documentoIdentidad, int telefono, String correoElectronico){
        this.nombreCompleto= nombreCompleto;
        this.documentoIdentidad= documentoIdentidad;
        this.telefono= telefono;
        this.correoElectronico= correoElectronico;

        comprasRealizadas= new ArrayList<>();
    }
    //Getters y setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }
    public void setDocumentoIdentidad(int documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Compras> getComprasRealizadas() {return comprasRealizadas;}
    public void setComprasRealizadas(List<Compras> comprasRealizadas) {this.comprasRealizadas = comprasRealizadas;}
    public void agregarComprasRealizada(Compras comprasRealizada){comprasRealizadas.add(comprasRealizada);}

    //ToString
    @Override
    public String toString(){
        return "Nombre: "+nombreCompleto+
                ", Documento de identidad: "+documentoIdentidad+
                ", Telefono: "+telefono+
                ", Correo electrónico: "+correoElectronico+
                ", comprasRealizadas: "+comprasRealizadas;
    }
}
