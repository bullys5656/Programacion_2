package parcialjunio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class OficinaComercial implements Serializable {

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Reserva> reservas;
    private int idOficina;
    private String nombreSuc;

    public OficinaComercial(String nombreSuc) {
        this.vehiculos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        Random r = new Random();
        this.idOficina = r.nextInt(100) + 1;
        this.nombreSuc=nombreSuc;
        
    }

    public OficinaComercial() {
        this.vehiculos = vehiculos;
        this.reservas = reservas;
        Random r = new Random();
        this.idOficina = r.nextInt(100) + 1;
        this.nombreSuc="";
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Reserva reservas) {
        this.reservas.add(reservas);
    }

    public int getIdOficina() {
        return idOficina;
    }
    public Reserva getInt(int pos){
    Reserva reserva =new Reserva();
    reserva=this.reservas.get(pos);
    
    return reserva;
    }

   public void quitarVehiculo(Vehiculo vehiculo){
      int i=0;
   if(!this.vehiculos.isEmpty()) {
      for ( i = 0; i < this.vehiculos.size(); i++) {
           if(this.vehiculos.get(i).equals(vehiculo)){
               break;
       }
    
    }
   this.vehiculos.remove(i);
   
   }
   else
   {
       System.out.println("LISTA DE AUTOS SIN ELEMENTOs");}
   
   
   
   }

    public String getNombreSuc() {
        return nombreSuc;
    }

    public void setNombreSuc(String nombreSuc) {
        this.nombreSuc = nombreSuc;
    }

    @Override
    public String toString() {
        return "ID: "+this.idOficina+" NOMBRE SUC: "+this.nombreSuc;
                
                
                }
    
    

}
