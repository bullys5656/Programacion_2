
package parcialjunio;
import java.io.Serializable;
   import static java.time.temporal.ChronoUnit.DAYS;
import java.time.LocalDate;


public class DetalleReserva implements Serializable{
        private int cantCombus;
        private LocalDate fechaInicio;
        private LocalDate fechaFinal;
        public DetalleReserva(){
        }

    public DetalleReserva(int cantCombus, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.cantCombus = cantCombus;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public DetalleReserva(LocalDate fechaInicio, LocalDate fechaFinal) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getCantCombus() {
        return cantCombus;
    }

    public void setCantCombus(int cantCombus) {
        this.cantCombus = cantCombus;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
       public int calcularDias(){
       //long dias= DAYS.between(fechaHoy, fechaProx); //FechaInicio,FechaFinal. Ha la diferencia entre dos fechas
       int totalDias=(int) DAYS.between(this.fechaInicio,fechaFinal);
       
       return totalDias;} 

    @Override
    public String toString() {
        return "###DetalleReserva###" + "\ncantCombus= " + cantCombus + "\nfechaInicio=" + fechaInicio + "\nfechaFinal= " + fechaFinal + "\nTotalDias= "+calcularDias();
    }

    
        
        
}
