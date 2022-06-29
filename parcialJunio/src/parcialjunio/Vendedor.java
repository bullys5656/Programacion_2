package parcialjunio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Random;
import java.util.Scanner;

public class Vendedor extends Persona implements Serializable {

    private int idVen;

    public Vendedor(String usuario, String password) {
        super(usuario, password);
        Random r = new Random();
        this.idVen = r.nextInt(100) + 1;
    }

    @Override
    public boolean proceder(Sistema sistema) {
        boolean cerrar = false;
        Scanner sc = new Scanner(System.in);
        while (!cerrar) {
            int op;
            do {
                System.out.println(
                        "RESERVA - ALQUILA FACIL\n\n"
                        + "[1] Cerrar Sesión\n"
                        + "[2] Alta Cliente\n"
                        + "[3] Cargar Reserva\n"
                        + "[4] Mostrar Reservas\n"
                        );

                op = sc.nextInt();

            } while (op < 1 || op > 4);
            if (op != 0 && op != 1) {
                switch (op) {
                    case 2:
                        altaCliente(sistema);
                        break;
                    case 3:
                        altaReserva(sistema);
                        break;
                    case 4:
                        mostrarReservas(sistema);
                        break;

                    case 0:
                        cerrar = true;
                        break;
                }
            } else if (op == 1) {
                System.out.println("Hasta pronto!");
                cerrar = true;
            }
        }
        return cerrar;
    }

    public void altaCliente(Sistema sistema) {
        String nom, pass, ape;
        String tel,
                direc,
                DNI;
        Scanner sc = new Scanner(System.in);
        //modificar ingreso

        System.out.println("INGRESO DE CLIENTE\n");
        System.out.println("Ingrese el Nombre\n");
        nom = sc.nextLine();
        System.out.println("Ingrese el Apellido\n");
        ape = sc.nextLine();
        System.out.println("Ingrese el PassWord\n");
        pass = sc.nextLine();
        System.out.println("Ingrese el DNI\n");
        DNI = sc.nextLine();
        System.out.println("Ingrese el Telefono\n");
        tel = sc.nextLine();
        System.out.println("Ingrese el Direccion\n");
        direc = sc.nextLine();
        // public Cliente(String nombre, String apellido, String DNI, String direccion, String tel,String pass)
        Persona cli = new Cliente(nom, ape, DNI, direc, tel, pass);
        sistema.agregarPersona(cli);
        System.out.println("Cliente agregado correctamente");
    }

    public void altaReserva(Sistema sistema) {
        String apellido;
        ArrayList<Vehiculo> vehiculosSeleccion = new ArrayList<>();
        ArrayList<OficinaComercial> oficinas = sistema.getOficinas();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el apellido del cliente");
        apellido = sc.nextLine();
        Cliente cliente = seleccionClien(sistema, apellido);
        System.out.println("" + cliente);
        if (cliente != null) {
            //Cliente cliente = seleccionClien(sistema, apellido);
            System.out.println("\nDetalle Reserva\n");
            mostrarOficinas(oficinas);
            OficinaComercial oficina = seleccionOfi(oficinas);
            System.out.println("Indique la fecha inicio de la Reserva DIA/MES/AÑO\n");
            LocalDate fechaInicio;
            LocalDate fechaFinal;
            String aux = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            fechaInicio = LocalDate.parse(aux, formatter);
            System.out.println("Indique la fecha Final de la Reserva DIA/MES/AÑO\n");
            aux = sc.nextLine();
            fechaFinal = LocalDate.parse(aux, formatter);
            System.out.println("INNGRESE LA CANTIDAD DE COMBUSTIBLE EN LISTROS \n");
            int combustible;
            combustible = sc.nextInt();
            DetalleReserva detallereserva = new DetalleReserva(combustible, fechaInicio, fechaFinal);
            mostrarVehiculos(oficina.getVehiculos());
            vehiculosSeleccion = seleccionVehi(vehiculosSeleccion, oficina.getVehiculos());
            Reserva reserva = new Reserva(detallereserva, vehiculosSeleccion, cliente);

            oficina.setReservas(reserva);
            // sistema.setReservas(reserva);

        } else {
            System.out.println("cargar el cliente");
            altaCliente(sistema);
        }

    }

    public OficinaComercial seleccionOfi(ArrayList<OficinaComercial> oficinas) {
        Scanner sc = new Scanner(System.in);

        int op = 0;
        OficinaComercial oficinaSele = new OficinaComercial();

        System.out.println("-->Indique el ID de la oficina a Seleccionar \n ");
        op = sc.nextInt();
        for (OficinaComercial oficina : oficinas) {
            if (oficina.getIdOficina() == op) {
                oficinaSele = oficina;
            }
        }

        return oficinaSele;
    }

    public ArrayList<Vehiculo> seleccionVehi(ArrayList<Vehiculo> vehiculosSeleccion, ArrayList<Vehiculo> vehiculos) {
        Scanner sc = new Scanner(System.in);

        int op = 0;

        do {
            System.out.println("-->Indique el ID del Vehiculo a Seleccionar \n--> Presione 0 para salir de la seleccion ");
            op = sc.nextInt();
            for (Vehiculo vehiculo1 : vehiculos) {
                if (vehiculo1.getIdVehiculo() == op) {
                    vehiculo1.setDisponible(false);
                    vehiculosSeleccion.add(vehiculo1);

                }
            }

        } while (op != 0);

        return vehiculosSeleccion;
    }

    public void mostrarVehiculos(ArrayList<Vehiculo> vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {

         
                System.out.println("" + vehiculo.toString() + "\n");
         

        }

    }

    public void mostrarOficinas(ArrayList<OficinaComercial> oficinas) {
        for (OficinaComercial oficina : oficinas) {
            System.out.println("" + oficina.toString() + "\n");

        }

    }

    public int getIdVen() {
        return idVen;
    }

    public void setIdVen(int idVen) {
        this.idVen = idVen;
    }

    public Cliente seleccionClien(Sistema sistema, String apellido) {
        ArrayList<Persona> personas = sistema.getPersonas();
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getClass().equals(Cliente.class)) {
                clientes.add((Cliente) persona);
            }
            for (Cliente cliente : clientes) {
                if (apellido.equals(cliente.getApellido())) {

                    return cliente;
                }

            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "####Vendedor###\n"
                + "" + "idVen= " + idVen + "\nApellido: " + this.getUsuario();
    }

    public void mostrarReservas(Sistema sistema) {
        ArrayList<OficinaComercial> oficinas = sistema.getOficinas();
        ArrayList<Reserva> reservas = new ArrayList<>();

        for (OficinaComercial oficina : oficinas) {
            for (Reserva reserva : oficina.getReservas()) {
                reservas.add(reserva);
            }

        }

        for (Reserva reserva : reservas) {
            {
                System.out.println("" + reserva);
            }
        }

    }

}
