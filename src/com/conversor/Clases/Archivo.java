package com.conversor.Clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Archivo {
  private static final String RUTA_ARCHIVO = "conversiones.json";

  public void guardarJson(String json) throws IOException {

    try(FileWriter escritura = new FileWriter(RUTA_ARCHIVO)){
      escritura.write(json);
    }
  }

  public void leerArchivo(){
    File archivo = new File(RUTA_ARCHIVO);

    if(!archivo.exists()){
      System.out.println("No hay transacciones guardadas");
      return;
    }

    System.out.println("\n --- HISTORIAL DE TRANSACCIONES ---");

    try(Scanner leerFichero = new Scanner(archivo)){
      if(!leerFichero.hasNextLine()){
        System.out.println("Archivo vacio");
        return;
      }

      while (leerFichero.hasNextLine()){
        String linea = leerFichero.nextLine();
        System.out.println(linea);
      }

    } catch (FileNotFoundException e) {
      System.out.println("Error al leer el archivo: "+e.getMessage());
    }

    System.out.println("\n --- FIN DEL HISTORIAL --- \n");
  }

}
