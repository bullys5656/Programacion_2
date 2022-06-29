package parcialjunio;

import java.io.Serializable;
import java.util.Random;

public class Vehiculo implements Serializable{

    private double precio;
    private String patente;
    private String marca;
    private String modelo;
    private String color;
    private boolean disponible;
    private int idVehiculo;
    public Vehiculo() {
    }

    public Vehiculo(double precio, String patente, String marca, String modelo, String color) {
        this.precio = precio;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.disponible = true;
           Random r = new Random();
        this.idVehiculo = r.nextInt(100) + 1;
        
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "###Vehiculo ####" + "\nprecio= $" + precio + "\npatente= " + patente + "\nmarca= " + marca + "\nmodelo= " + modelo + "\ncolor=" + color + "\ndisponible= " + disponible + "\nidVehiculo= " + idVehiculo ;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

}
