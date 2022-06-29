package parcialjunio;

import java.io.Serializable;
import java.util.ArrayList;


public class Reserva implements Serializable {

    private DetalleReserva detalleReserva;
    private ArrayList<Vehiculo> vehiculos;
    private Boolean estadoAlquiler;
    private double precioTotal;
    private Cliente cliente;

    public Reserva() {
        this.vehiculos = new ArrayList<>();
        this.estadoAlquiler = true;
        this.cliente = new Cliente();
        this.detalleReserva = new DetalleReserva();
    }

    public Reserva(DetalleReserva detalleReserva, ArrayList<Vehiculo> vehiculos, Cliente cliente) {
        this.detalleReserva = detalleReserva;
        this.vehiculos = vehiculos;
        this.cliente = cliente;
        calcularPrecio();
        cambiarEstadoV();
    }

    public DetalleReserva getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(DetalleReserva detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Boolean getEstadoAlquiler() {
        return estadoAlquiler;
    }

    public void setEstadoAlquiler(Boolean estadoAlquiler) {
        this.estadoAlquiler = estadoAlquiler;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void calcularPrecio(){
   double aux=0;
   int cantVehi=vehiculos.size();
        for (Vehiculo vehiculo : vehiculos) {
            aux=aux+vehiculo.getPrecio();
            
        }
        this.precioTotal=(aux+(cantVehi*detalleReserva.getCantCombus()))*detalleReserva.calcularDias();
    
    }
    
    public void cambiarEstadoV(){
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.setDisponible(false);
            
        }
    }

    @Override
    public String toString() {
        return "Reserva{" + "detalleReserva=" + detalleReserva + ", vehiculos=" + vehiculos + ", estadoAlquiler=" + estadoAlquiler + ", precioTotal=" + precioTotal + ", cliente=" + cliente + '}';
    }

   
}
