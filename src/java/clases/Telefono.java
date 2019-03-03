package clases;

public class Telefono {
    
    private String numero;
    private String contacto;

    public Telefono(String numero, String contacto) {
        this.numero = numero;
        this.contacto = contacto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
}
