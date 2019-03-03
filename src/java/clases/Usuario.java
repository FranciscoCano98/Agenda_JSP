package clases;

/**
 *
 * @author franc
 */
public class Usuario {
    private String nombre;
    private String apellidos;
    private String login;
    private String clave;
    private boolean activo;

    public Usuario(String nombre, String apellidos, String login, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.login = login;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
     
}


