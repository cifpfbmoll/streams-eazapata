package p7e1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lecturaEscritura {

    public static String pedirOrigen() throws RutaInvalida {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el archivo de orgien:");
        String archivoOrigen = sc.nextLine();
        File entrada = new File(archivoOrigen);
        if (entrada.exists()) {
            System.out.println("El archivo " + archivoOrigen + " existe.");
        } else {
            throw new RutaInvalida("001");
        }
        return archivoOrigen;
    }

    public static String pedirDestino() throws RutaInvalida {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el archivo de destino:");
        String archivoDestino = sc.nextLine();
        File salida = new File(archivoDestino);
        if (salida.exists()) {
            System.out.println("El archivo " + archivoDestino + " existe.");
        } else {
            throw new RutaInvalida("002");
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
            for (int j = 0; j < info.length; j++) {
                if (i == 0) {
                    salida.write(camposPeli[j] + info[j] + lineas + "\n");
                } else {
                    salida.write(camposPeli[j] + info[j] + "\n");
                }

            }
        }
        entrada.close();
        salida.close();
    }

    public static void crearCarteleraBuffers(String archivoEntrada, String archivoSalida, String cabecera, String lineas, String[] camposPeli) throws IOException {

        BufferedReader entrada = new BufferedReader(new FileReader(archivoEntrada));
        BufferedWriter salida = new BufferedWriter(new FileWriter(archivoSalida, true));

        String lineaLeida = entrada.readLine();

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

    public static void escribirObjetos(String entrada, String salida) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader(entrada));
        ObjectOutputStream fout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(salida,true)));

        String linea = fin.readLine();

        String[] peliculas = linea.split("\\{");
        
        for (String pelicula : peliculas) {
            Pelicula p = new Pelicula();
            String[] datosLinea = pelicula.split("#");
            for (int i = 0; i < datosLinea.length; i++) {
                switch (i) {
                    case 0:
                        p.setTitulo(datosLinea[i]);
                        System.out.println(datosLinea[i]);
                        break;
                    case 1:
                        p.setAño(datosLinea[i]);
                        System.out.println(datosLinea[i]);
                        break;
                    case 2:
                        p.setDirector(datosLinea[i]);
                        System.out.println(datosLinea[i]);
                        break;
                    case 3:
                        p.setDuracion(datosLinea[i]);
                        System.out.println(datosLinea[i]);
                        break;
                    case 4:
                        p.setSinopsis(datosLinea[i]);
                        System.out.println(datosLinea[i]);
                        break;
                    case 5:
                        p.setReparto(datosLinea[i]);
                        System.out.println(datosLinea[i]);
                        break;
                    case 6:
                        p.setSesion(datosLinea[i]);
                        System.out.println(datosLinea[i]);
                        break;
                }

            }
            fout.writeObject(p);
        }
        fin.close();
        fout.close();
    }

    public static void leerObjetos(String entrada) throws IOException {
         try (ObjectInputStream objectEntrada = new ObjectInputStream(new FileInputStream((entrada)))) {
            boolean eof = false;
            Pelicula p = new Pelicula();
            while (!eof) {
                p = (Pelicula) objectEntrada.readObject();
                p.mostrarPelicula();
            }
        } catch (EOFException e) {
            System.out.println("fin de fichero");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de clase");
        } catch (IOException ex) {
            System.out.println("Error de lectura");
             System.out.println(ex.getStackTrace());
        }

    }

}
