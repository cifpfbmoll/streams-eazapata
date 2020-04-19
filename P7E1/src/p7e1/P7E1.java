package p7e1;

import java.util.*;
import java.io.*;

public class P7E1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String cabecera = "------------Cartelera Cartelera de CineFBMoll---------------------" + "\n";
        final String titulo = "------------Titulo: ";
        final String lineas = "------------";
        final String año = "Año: ";
        final String director = "Director: ";
        final String duracion = "Duración: ";
        final String sinopsis = "Sinopsis: ";
        final String reparto = "Reparto: ";
        final String sesion = "Sesión: ";
        String entrada, salida;

        String[] camposPeli = {titulo, año, director, duracion, sinopsis, reparto, sesion};

        boolean salir = false;
        try {
            while (!salir) {
                System.out.println("\t-------------------------------MENÚ--------------------------------");
                System.out.println("\t1) Lectura y escritura del fichero de cartelera byte a byte (byte Streams).");
                System.out.println("\t2) Lectura y escritura de fichero de cartelera carácter a carácter (character Streams)");
                System.out.println("\t3) Lectura y escritura de fichero línea a línea con buffers (character Streams)");
                System.out.println("\t4) Tratamiento de objetos.");
                System.out.println("\t5) Salir.");

                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        entrada = lecturaEscritura.pedirOrigen();
                        salida = lecturaEscritura.pedirDestino();
                        lecturaEscritura.crearCarteleraBytes(entrada, salida, cabecera, lineas, camposPeli);
                        break;
                    case 2:
                        entrada = lecturaEscritura.pedirOrigen();
                        salida = lecturaEscritura.pedirDestino();
                        lecturaEscritura.crearCarteleraCharacter(entrada, salida, cabecera, lineas, camposPeli);
                        break;
                    case 3:
                        entrada = lecturaEscritura.pedirOrigen();
                        salida = lecturaEscritura.pedirDestino();
                        lecturaEscritura.crearCarteleraBuffers(entrada, salida, cabecera, lineas, camposPeli);
                        break;
                    case 4:
                        mostrarSubmenu();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("La opción introducia no es válida.");
                }

            }

        } catch (NumberFormatException exc) {
            System.out.println("No ha introducido un número.");
            exc.getMessage();
        } catch (IOException ex) {
            System.out.println("Error de lectura escritura.");
        } catch (RutaInvalida rutaInv) {
            rutaInv.imprimirError();
            rutaInv.escribirFichero();

        }
    }

    public static void mostrarSubmenu() throws RutaInvalida, IOException {
        Scanner sc = new Scanner(System.in);
        String entrada, salida;
        boolean salirObjetos = false;
        while (!salirObjetos) {
            System.out.println("\ta) Lectura línea a línea y escritura con objetos (obteniendo ficheroSalObj).");
            System.out.println("\tb) Lectura de objetos (leyendo ficheroSalObj) y escritura de objetos (obteniendo ficheroSalObj2).");
            System.out.println("\tc) Lectura de objetos (leyendo ficheroSalObj2) y escritura por consola (comprobaremos por consola que nos ha escrito bien los objetos en los pasos anteriores).");
            System.out.println("\td) Volver al menú principal.");

            String opcionObjetos = sc.nextLine();

            switch (opcionObjetos) {
                case "a":
                    entrada = lecturaEscritura.pedirOrigen();
                    salida = lecturaEscritura.pedirDestino();
                    lecturaEscritura.escribirObjetos(entrada, salida);
                    break;
                case "b":
                    break;
                case "c":
                    entrada = lecturaEscritura.pedirOrigen();
                    lecturaEscritura.leerObjetos(entrada);
                    break;
                case "d":
                    salirObjetos = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        }
    }

}
