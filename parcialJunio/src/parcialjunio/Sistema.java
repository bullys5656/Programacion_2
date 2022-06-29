package parcialjunio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Werner
 */
public class Sistema implements Serializable {

    private Administrador a;
    private ArrayList<Persona> personas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Reserva> reservas;
    private ArrayList<OficinaComercial> oficinas;

    public Sistema() {
        personas = new ArrayList<>();
        vehiculos = new ArrayList<>();
        reservas = new ArrayList<>();
        oficinas = new ArrayList<>();

    }

    public Sistema deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();
        o.close();
        f.close();
        return s;
    }

    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public Persona buscarPersona(String datos) {
        int i = 0;
        boolean encontrado = false;
        Persona p = null;

        while (i < personas.size() && !encontrado) {
            p = personas.get(i);
            if (datos.equals(p.getUsuario() + ":" + p.getPassword())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            return null;
        } else {
            return p;
        }
    }

    public void agregarPersona(Persona p) {
        if (p != null) {
            personas.add(p);
        }
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void agregarVehiculo(Vehiculo v) {
        if (v != null) {
            vehiculos.add(v);
        }
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Administrador getA() {
        return a;
    }

    public void setA(Administrador a) {
        this.a = a;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    void iniciar() {
        boolean corriendo = true;
        while (corriendo) {
            Persona u = null;
            do {
                Scanner teclado = new Scanner(System.in);
                System.out.println("Ingrese su usuario");
                String usuario = teclado.nextLine();
                System.out.println("Ingrese su contraseña");
                String password = teclado.nextLine();
                for (Persona p : personas) {
                    if (p.getUsuario().equalsIgnoreCase(usuario) && p.getPassword().equals(password)) {
                        u = p;
                        break;
                    }
                }
                if (u == null) {
                    System.out.println("Usuario/Contraseña incorrecto o inexistente");
                } else {
                    System.out.println("Bienvenido " + u.getUsuario());
                }

            } while (u == null);
            corriendo = u.proceder(this);
        }
        System.out.println("Hasta mañana!");
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Reserva reservas) {
        this.reservas.add(reservas);
    }

    public ArrayList<OficinaComercial> getOficinas() {
        return oficinas;
    }
    public OficinaComercial getById(int id){
        OficinaComercial ofi=new OficinaComercial   ();
        for (OficinaComercial oficina : oficinas) {
            if(id==oficina.getIdOficina()){
            ofi=oficina;
            
            }   }
    return ofi;
    }

    public void setOficinas(OficinaComercial oficina) {
        this.oficinas.add(oficina);
    }
    
   public void quitarPersona(Vendedor persona){
   
       int  aux=0;
       for (int i = 0; i < this.personas.size();i ++) {
           if(this.personas.get(i).equals(persona)){
           aux=i;
           
           }
       }
   if(aux!=0){
   personas.remove(aux);
   }
   }
}
