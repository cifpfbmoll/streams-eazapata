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
                System.out.println("\t4) Salir.");

                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        entrada = pedirOrigen();
                        salida = pedirDestino();
                        crearCarteleraBytes(entrada, salida, cabecera, lineas, camposPeli);
                        break;
                    case 2:
                        entrada = pedirOrigen();
                        salida = pedirDestino();
                        crearCarteleraCharacter(entrada, salida, cabecera, lineas, camposPeli);
                        break;
                    case 3:
                        entrada = pedirOrigen();
                        salida = pedirDestino();
                        crearCarteleraBuffers(entrada, salida, cabecera, lineas, camposPeli);
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("La opción introducia no es válida.");
                }

            }

        } catch (NumberFormatException exc) {
            System.out.println("No ha introducido un número.");
            exc.getMessage();
        } catch (IOException file) {
            System.out.println("Archivo no encontrado.");
            System.out.println(file.getMessage());
        }
    }

    public static String pedirOrigen() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el archivo de orgien:");
        String archivoOrigen = sc.nextLine();
        File entrada = new File(archivoOrigen);
        if (entrada.exists()) {
            System.out.println("El archivo " + archivoOrigen + " existe.");
        } else {
            System.out.println("Archivo no encontrado.");
            archivoOrigen = "";
        }
        return archivoOrigen;
    }

    public static String pedirDestino() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el archivo de destino:");
        String archivoDestino = sc.nextLine();
        File salida = new File(archivoDestino);
        if (salida.exists()) {
            System.out.println("El archivo " + archivoDestino + " existe.");
        } else {
            System.out.println("Archivo no encontrado.");
            archivoDestino = "";
        }
        return archivoDestino;
    }

    public static void crearCarteleraBytes(String archivoEntrada, String archivoSalida, String cabecera, String lineas, String[] camposPeli) throws IOException {

        String cartelera = "";

        int i = 0;
        FileInputStream entrada = new FileInputStream(archivoEntrada);
        FileOutputStream salida = new FileOutputStream(archivoSalida, true);
        while (i != -1) {

            i = entrada.read();
            cartelera += ((char) i);
        }
        String[] peliculas = cartelera.split("\\{");
        String[] info;
        salida.write(cabecera.getBytes());
        for (String pelicula : peliculas) {
            info = pelicula.split("#");
            for (int k = 0; k < info.length; k++) {
                switch (k) {
                    case 0:
                        salida.write(camposPeli[k].getBytes());
                        salida.write(info[k].getBytes());
                        salida.write(lineas.getBytes());
                        salida.write("\n".getBytes());
                        break;
                    case 1:
                        salida.write(camposPeli[k].getBytes());
                        salida.write(info[k].getBytes());
                        salida.write("\n".getBytes());
                        break;
                    case 2:
                        salida.write(camposPeli[k].getBytes());
                        salida.write(info[k].getBytes());
                        salida.write("\n".getBytes());
                        break;
                    case 3:
                        salida.write(camposPeli[k].getBytes());
                        salida.write(info[k].getBytes());
                        salida.write("\n".getBytes());
                        break;
                    case 4:
                        salida.write(camposPeli[k].getBytes());
                        salida.write(info[k].getBytes());
                        salida.write("\n".getBytes());
                        break;
                    case 5:
                        salida.write(camposPeli[k].getBytes());
                        salida.write(info[k].getBytes());
                        salida.write("\n".getBytes());
                        break;
                    case 6:
                        salida.write(camposPeli[k].getBytes());
                        salida.write(info[k].getBytes());
                        salida.write("\n".getBytes());
                        break;

                }

            }
        }
        entrada.close();
        salida.close();
    }

    public static void crearCarteleraCharacter(String archivoEntrada, String archivoSalida, String cabecera, String lineas, String[] camposPeli) throws IOException {

        FileReader entrada = new FileReader(archivoEntrada);
        FileWriter salida = new FileWriter(archivoSalida, true);
        String cartelera = "";

        int i = 0;
        while (i != -1) {

            i = entrada.read();
            cartelera += ((char) i);
        }
        String[] peliculas = cartelera.split("\\{");
        String[] info;
        salida.write(cabecera);
        for (String pelicula : peliculas) {
            info = pelicula.split("#");
            for (int k = 0; k < info.length; k++) {
                switch (k) {
                    case 0:
                        salida.write(camposPeli[k]);
                        salida.write(info[k] + "\n");
                        salida.write(lineas);
                        salida.write("\n");
                        break;
                    case 1:
                        salida.write(camposPeli[k]);
                        salida.write(info[k]);
                        salida.write("\n");
                        break;
                    case 2:
                        salida.write(camposPeli[k]);
                        salida.write(info[k]);
                        salida.write("\n");
                        break;
                    case 3:
                        salida.write(camposPeli[k]);
                        salida.write(info[k]);
                        salida.write("\n");
                        break;
                    case 4:
                        salida.write(camposPeli[k]);
                        salida.write(info[k]);
                        salida.write("\n");
                        break;
                    case 5:
                        salida.write(camposPeli[k]);
                        salida.write(info[k]);
                        salida.write("\n");
                        break;
                    case 6:
                        salida.write(camposPeli[k]);
                        salida.write(info[k]);
                        salida.write("\n");
                        break;

                }

            }
        }
        entrada.close();
        salida.close();

    }

    public static void crearCarteleraBuffers(String archivoEntrada, String archivoSalida, String cabecera, String lineas, String[] camposPeli) throws IOException {

        BufferedReader entrada = new BufferedReader(new FileReader(archivoEntrada));
        BufferedWriter salida = new BufferedWriter(new FileWriter(archivoSalida));

        String lineaLeida = "";

        lineaLeida = entrada.readLine();

        salida.write(cabecera);

        String[] peliculas = lineaLeida.split("\\{");
        for (String pelicula : peliculas) {
            String[] datosLinea = pelicula.split("#");
            for (int i = 0; i < datosLinea.length; i++) {
                if (i == 0) {
                    salida.write(camposPeli[i] + datosLinea[i] + lineas + "\n");
                } else {
                    salida.write(camposPeli[i] + datosLinea[i] + "\n");
                }

            }
        }
        entrada.close();
        salida.close();
    }

}
