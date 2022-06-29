package parcialjunio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cliente extends Persona implements Serializable {

    private String apellido;
    private String nombre;
    private String DNI;
    private String direccion;
    private String tel;
    private int idCliente;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String DNI, String direccion, String tel, String pass) {
        super(apellido, pass);
        this.apellido = apellido;
        this.DNI = DNI;
        this.tel = tel;
        this.direccion = direccion;
        this.nombre = nombre;
        Random r = new Random();
        this.idCliente = r.nextInt(100) + 1;

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean proceder(Sistema sistema) {
        boolean cerrar = false;
        Scanner sc= new Scanner(System.in);
        while (!cerrar) {
            int op;
            do {
                System.out.println(
                        "CLIENTE - ALQUILA FACIL\n\n"
                        + "[1] Cerrar Sesión\n"
                        + "[2] Ver Reservas\n"
                        );
                op=sc.nextInt();
            } while (op < 1 || op > 3);
            if (op != 0 && op != 1) {
                switch (op) {
                    case 2:
                        mostrarReservas(sistema);
                        break;
                    case 3:

                        break;
                }
            } else if (op == 1) {
                System.out.println("Hasta pronto!");
                cerrar = true;
            }
        }
        return cerrar;
    }

    public void mostrarReservas(Sistema sistema) {
        ArrayList <OficinaComercial> oficinas=sistema.getOficinas();
       ArrayList <Reserva> reservas= new ArrayList<>();
  
        for (OficinaComercial oficina :oficinas) {
            for (Reserva reserva : oficina.getReservas()) {
                reservas.add(reserva);
            }
            
        }
            
        for (Reserva reserva : reservas) {
            if(this.idCliente==reserva.getCliente().idCliente){
                System.out.println(""+reserva);
            }
        }
       
            
        }

    @Override
    public String toString() {
        return "###Cliente###\n" + "\napellido= " + apellido + "\nnombre= " + nombre + "\nDNI= " + DNI + "\ndireccion= " + direccion + "\ntel=" + tel + "\nidCliente= " + idCliente ;
    }
        
        
        
        

    


}
