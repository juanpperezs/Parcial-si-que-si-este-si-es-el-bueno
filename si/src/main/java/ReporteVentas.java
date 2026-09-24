import java.time.LocalDate;

public class ReporteVentas {

    //Atributos
    private int valorReporte;
    private LocalDate fechaReporte;
    private int valorAcumulado;

    //Constructor
    public ReporteVentas(int valorReporte, LocalDate fechaReporte, int valorAcumulado) {
        this.valorReporte = valorReporte;
        this.fechaReporte = fechaReporte;
        this.valorAcumulado = valorAcumulado;
    }

    //Getters y setters
    public int getValorReporte() {
        return valorReporte;
    }
    public void setValorReporte(int valorReporte) {
        this.valorReporte = valorReporte;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }
    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public int getValorAcumulado() {
        return valorAcumulado;
    }
    public void setValorAcumulado(int valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    //toString

    @Override
    public String toString() {
        return "ReporteVentas{" +
                "valorReporte=" + valorReporte +
                ", fechaReporte=" + fechaReporte +
                ", valorAcumulado=" + valorAcumulado +
                '}';
    }
}
