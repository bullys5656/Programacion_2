package parcialjunio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador extends Persona implements Serializable {

    private int idAdministrador;

    public Administrador(String usario, String password) {
        super(usario, password);
    }

    public Administrador(int idAdministrador, String usario, String password) {
        super(usario, password);
        this.idAdministrador = idAdministrador;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public boolean proceder(Sistema sistema) {
        List<Persona> personas = sistema.getPersonas();
        // personas.forEach(System.out::println);
        boolean seguirCorriendo = true;
        boolean cerrar = false;
        while (!cerrar) {
            Scanner teclado = new Scanner(System.in);
            int op;
            do {
                System.out.println(
                        "###  ADMINISTRACION CART-RENT ###\n\n"
                        + "[0] SALIR del Sistema\n"
                        + "[1] Cerrar Sesión\n"
                        + "[2] MENU Vehiculo\n"
                        + "[3] MENU Usuario\n"
                        + "[4] Alta Oficina Comercial\n");
                op = teclado.nextInt();
            } while (op < 0 || op > 4);
            switch (op) {
                case 0:
                    seguirCorriendo = false;
                    cerrar = true;
                    break;
                case 1:
                    cerrar = true;
                    System.out.println("Hasta pronto!");
                    break;
                case 2:
                    menuVehiculo(sistema);
                    break;
                case 3:
                    altaUsuario(sistema);
                    break;
                case 4:
                    altaOficinaComercial(sistema);
                    break;
            }
        }
        return seguirCorriendo;
    }

    private void menuVehiculo(Sistema sistema) {
        int cat = 0;
        boolean cerrar = false;
        while (!cerrar) {
            Scanner teclado = new Scanner(System.in);
            do {

                System.out.println(
                        "###  MENU VEHICULO ###\n\n"
                        + "[1] ALTA VEHICULO\n"
                        + "[2] BAJA VEHICULO\n"
                        + "[3] MOSTAR LISTA VEHICULOS\n"
                        + "[4] SALIR");
                cat = teclado.nextInt();
            } while (cat < 1 || cat > 4);
            switch (cat) {
                case 1:
                    System.out.println("\n###  BAJA VEHICULO ###\\n\\n\"");
                    altaVehiculo(sistema);
                    break;
                case 2:
                    mostrarVehiculos(sistema);
                    bajaVehiculo(sistema);
                    break;
                case 3:
                    mostrarVehiculos(sistema);
                    break;
                case 4:
                    cerrar = true;
                    break;

            }
        }
    }

    private void bajaVehiculo(Sistema sistema) {

        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESA EL ID DEL VEHICULO PARA SU BAJA");
        int id = sc.nextInt();
        OficinaComercial laofi = new OficinaComercial();
        Vehiculo vehi = new Vehiculo();
        ArrayList<OficinaComercial> oficinas = sistema.getOficinas();

        for (OficinaComercial oficina : oficinas) {
            if (!oficina.getVehiculos().isEmpty()) {

                for (Vehiculo vehiculo : oficina.getVehiculos()) {
                    if (vehiculo.getIdVehiculo() == id) {
                        laofi = oficina;
                        vehi = vehiculo;

                    }
                }
            }
        }

        laofi.quitarVehiculo(vehi);

    }

    private void mostrarVehiculos(Sistema sistema) {
        ArrayList<OficinaComercial> oficinas = sistema.getOficinas();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        for (OficinaComercial oficina : oficinas) {
            for (Vehiculo vehiculo : oficina.getVehiculos()) {
                vehiculos.add(vehiculo);
            }
        }
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println("" + vehiculo);
            }
        } else {
            System.out.println("#####LISTA DE AUTOS VACIA#####\n");
        }

    }

    private void altaUsuario(Sistema s) {
        String direccion, password, apellido, telefono, nombre, DNI;
        int cat;
        //  ArrayList<Integer> dias = new ArrayList<>();
        boolean cerrar = false;
        while (!cerrar) {
            Scanner teclado = new Scanner(System.in);
            do {
                System.out.println("APRETE ENTRER PARA CONTINUAR");
                teclado.nextLine();

                System.out.println(
                        "###  MENU USUARIO ###\n\n"
                        + "[1] ALTA Vendedor\n"
                        + "[2] ALTA Cliente\n"
                        + "[3] MOSTRAR Clientes\n"
                        + "[4] MOSTRAR Vendedores\n"
                        + "[5] SALIR");
                cat = teclado.nextInt();
            } while (cat < 1 || cat > 5);
            switch (cat) {
                case 1:
                    System.out.println("APRETE ENTRER PARA CONTINUAR");
                    teclado.nextLine();
                    System.out.println("###  ALTA VENDEDOR ###");

                    System.out.println("VENDEDOR\nIngrese su apellido");
                    apellido = teclado.nextLine();
                    System.out.println("VENDEDOR\nIngrese su contraseña");
                    password = teclado.nextLine();
                    Persona v = new Vendedor(apellido, password);
                    //PersonaService.guardarPersona(v);
                    s.agregarPersona(v);
                    System.out.println("Usuario agregado correctamente");
                    break;
                case 2:
                    System.out.println("APRETE ENTRER PARA CONTINUAR");
                    teclado.nextLine();
                    System.out.println("###  ALTA CLIENTE ###");
                    System.out.println("CLIENTE\nIngrese nombre");
                    nombre = teclado.nextLine();
                    System.out.println("CLIENTE\nIngrese su apellido");
                    apellido = teclado.nextLine();
                    System.out.println("CLIENTE\nIngrese su contraseña");
                    password = teclado.nextLine();
                    System.out.println("CLIENTE\nIngrese nro de DNI");
                    DNI = teclado.nextLine();
                    System.out.println("CLIENTE\nIngrese nro de Telefono");
                    telefono = teclado.nextLine();
                    System.out.println("CLIENTE\nIngrese la direccion ");
                    direccion = teclado.nextLine();
                    Persona c = new Cliente(nombre, apellido, DNI, direccion, telefono, password);
                    s.agregarPersona(c);

                    System.out.println("Usuario agregado correctamente");
                    break;
                case 3:
                    mostrarClientes(s);
                    break;
                case 4:
                    mostrarVendedores(s);
                    break;
                case 5:

                    cerrar = true;
                    break;
            }
        }
    }

    private void mostrarClientes(Sistema sistema) {

        ArrayList<Persona> personas = sistema.getPersonas();
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getClass().equals(Cliente.class)) {
                clientes.add((Cliente) persona);
            }

        }
        for (Cliente cliente : clientes) {
            System.out.println("" + cliente);
        }
    }

    private void mostrarVendedores(Sistema sistema) {

        ArrayList<Persona> personas = sistema.getPersonas();
        ArrayList<Vendedor> vendedor = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getClass().equals(Vendedor.class)) {
                vendedor.add((Vendedor) persona);
            }

        }
        for (Vendedor vender : vendedor) {
            System.out.println("" + vender);
        }
    }

    private void altaVehiculo(Sistema s) {
        String patente, marca, modelo, color;
        Double precio;
        ArrayList<OficinaComercial> oficinas = s.getOficinas();
        char op;
        System.out.println("APRETE ENTRER PARA CONTINUAR");
        Scanner teclado = new Scanner(System.in);

        System.out.println("###  ALTA DE VEHÍCULO ###");
        do {
            System.out.println("APRETE ENTRER PARA CONTINUAR");
            teclado.nextLine();
            System.out.println("Nro Patente");
            patente = teclado.nextLine();
            System.out.println("Marca del Vehículo");
            marca = teclado.nextLine();
            System.out.println("Modelo");
            modelo = teclado.nextLine();
            System.out.println("Color");
            color = teclado.nextLine();
            System.out.println("Precio de Alquiler");
            precio = teclado.nextDouble();
            Vehiculo v = new Vehiculo(precio, patente, marca, modelo, color);

            // s.agregarVehiculo(v);
            mostrarOficinas(oficinas);
            OficinaComercial oficina = seleccionOfi(oficinas);
            s.getById(oficina.getIdOficina()).setVehiculos(v);
            System.out.println("Vehículo agregado correctamente a la lista");
            System.out.println("Desea agregar mas Vehiculos(S/N)");
            op = teclado.next().charAt(0);
        } while (op == 's' || op == 'S');
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

    public void mostrarOficinas(ArrayList<OficinaComercial> oficinas) {
        for (OficinaComercial oficina : oficinas) {
            System.out.println("" + oficina.toString() + "\n");

        }

    }

    @Override
    public String toString() {
        return "Administrador{"
                + "idAdministrador=" + idAdministrador
                + super.toString()
                + '}';
    }

    public void altaOficinaComercial(Sistema s) {
        String nombSuc;
        Scanner teclado = new Scanner(System.in);

        System.out.println("APRETE ENTRER PARA CONTINUAR");
        teclado.nextLine();
        System.out.println("###  ALTA OFICINA COMERCIAL ###");

        System.out.println("OFICINA COMERCIAL\nINGRESE EL NOMBRE DE LA SUCURSAL:     ");
        nombSuc = teclado.nextLine();
        OficinaComercial ofi = new OficinaComercial(nombSuc);
        s.setOficinas(ofi);
        System.out.println("Oficina  agregada correctamente a la lista");

    }

}
