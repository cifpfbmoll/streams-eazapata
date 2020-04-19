
package p7e1;
import java.io.*;
import java.util.*;


public class Pelicula implements Serializable{
    private String titulo;
    private String año;
    private String director;
    private String duracion;
    private String sinopsis;
    private String reparto;
    private String sesion;

    public Pelicula() {
    }

    public Pelicula(String titulo, String año, String director, String duracion, String sinopsis, String reparto, String sesion) {
        this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.sesion = sesion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }
    
    public void mostrarPelicula(){
        
        System.out.println("Título "+this.getTitulo());
        System.out.println("Año: "+this.getAño());
        System.out.println("Director: "+this.getDirector());
        System.out.println("Duración: "+this.getDuracion()+" minutos.");
        System.out.println("Sinopsis: "+this.getSinopsis());
        System.out.println("Reparto: "+this.getReparto());
        System.out.println("Sesión "+this.getSesion());
    }
    

    
}
