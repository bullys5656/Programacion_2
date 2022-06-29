
package parcialjunio;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    private String usuario;
    private String password;

    public Persona(String usario ,String password){
        this.usuario= usario;
        this.password=password;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public abstract boolean proceder(Sistema sistema);

}
