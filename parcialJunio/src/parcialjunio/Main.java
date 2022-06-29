
package parcialjunio;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
    Sistema s = new Sistema();
        try {
            s = s.deSerializar("carRent.txt");
            System.out.println("BIENVENDO A CAR RENT");
        } catch (ClassNotFoundException | IOException e) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("CARGANDO SISTEMA 1ra VEZ");
            System.out.println("Registre su usuario: ");
            String usuario  = teclado.nextLine();
            System.out.println("Registre su contraseña: ");
            String password = teclado.nextLine();
            Administrador a = new Administrador(usuario, password);
            s.agregarPersona(a);
            //PersonaService.setPersonas(s.getPersonas());
            System.out.println("Usted es el nuevo administrador, por favor logearse");
        }
        s.iniciar();
        s.serializar("carRent.txt");
    }
    
}
