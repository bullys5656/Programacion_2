
package parcialjunio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;

public class EntradaSalida {

    public static char leerChar(String texto) {
        String st = JOptionPane.showInputDialog(texto);
        return (st == null || st.length() == 0 ? '0' : st.charAt(0));
    }

    public static String leerString(String texto) {
        String st = JOptionPane.showInputDialog(texto);
        return (st == null ? "" : st);
    }

    public static int leerInt(String texto) {
        int val = -1;
        boolean valido;
        do {
            String st = JOptionPane.showInputDialog(texto);
            try {
                val = Integer.parseInt(st);
                valido = true;
            } catch (NumberFormatException ex) {
                mostrarString("Ingrese un entero!!!\n(En lugar de " + st + ")");
                valido = false;
            }
        } while (!valido);
        return val;
    }

    public static boolean leerBoolean(String texto) {
        int i = JOptionPane.showConfirmDialog(null, texto, "Consulta", JOptionPane.YES_NO_OPTION);
        return i == JOptionPane.YES_OPTION;
    }

    public static void mostrarString(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public static String leerPassword(String texto) {
        final JPasswordField pwd = new JPasswordField();
        ActionListener al;
        al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pwd.requestFocusInWindow();
            }
        };
        Timer timer = new Timer(200, al);
        timer.setRepeats(false);
        timer.start();
        Object[] objs = {texto, pwd};
        String password = "";
        if (JOptionPane.showConfirmDialog(null, objs, "Entrada",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
            password = String.valueOf(pwd.getPassword());
        }
        return password;
    }
}
