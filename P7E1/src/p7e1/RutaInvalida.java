package p7e1;

import java.io.*;
import java.sql.Timestamp;
import java.util.Arrays;

public class RutaInvalida extends Exception {

    private String mensaje;

    public RutaInvalida(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void imprimirError() {
        switch (this.getMensaje()) {
            case "001":
                System.out.println("No se ha encontrado el archivo de origen.");
                break;
            case "002":
                System.out.println("No se ha encontrado el archivo de destino.");
                break;
            default:
                System.out.println("Error relacionado con los archivos de origen o destino.");
        }

    }

    public void escribirFichero() {
        try (FileWriter ferror = new FileWriter("error.txt", true)) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ferror.write(timestamp.toString());
            ferror.write(Arrays.toString(this.getStackTrace()));
        } catch (IOException ex) {
            System.out.println("Error abriendo error.txt");
        }
    }
}
