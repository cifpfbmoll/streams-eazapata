
package p7e1;


public class NotFoundException extends Exception{
    
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public NotFoundException(String mensaje) {
        this.mensaje = mensaje;
    }

    public NotFoundException() {
    }

    
    
    
    
    
    
}
