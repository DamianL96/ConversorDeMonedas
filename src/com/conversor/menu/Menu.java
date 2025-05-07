package com.conversor.menu;

import com.conversor.calculo.Calculo;
import com.conversor.connection.AdaptaJson;
import com.conversor.connection.Conexion;
import com.conversor.records.Rate;

import java.util.Scanner;

public class Menu {


  public void run(){
    Scanner teclado = new Scanner(System.in);


    int opcion = 0;
    double monto = 0;

    do {
      String base = "";
      String target = "";

      System.out.println("****************************");
      System.out.println("1) Dolar a Peso Argentinto");
      System.out.println("2) Peso Argentinto a Dolar");
      System.out.println("3) Dolar a Euro");
      System.out.println("4) Euro a Dolar");
      System.out.println("5) Peso Argentinto a Euro");
      System.out.println("6) Euro a Peso Argentino");
      System.out.println("7) Salir");
      System.out.println("SELECCIONE UNA OPCION VALIDA");
      System.out.println("****************************");

      opcion = teclado.nextInt();

      switch (opcion){ /// Crear el constructor para la conexion con la moneda base y la moneda target
        case 1:
          System.out.println("1");
          base = "USD";
          target = "ARS";
          break;
        case 2:
          System.out.println("2");
          base = "ARS";
          target = "USD";
          break;
        case 3:
          System.out.println("3");
          base = "USD";
          target = "EUR";
          break;
        case 4:
          System.out.println("4");
          base = "EUR";
          target = "USD";
          break;
        case 5:
          System.out.println("5");
          base = "ARS";
          target = "EUR";
          break;
        case 6:
          System.out.println("6");
          base = "EUR";
          target = "ARS";
          break;
      }

      Conexion coneccion = new Conexion(base,target);
      System.out.println(coneccion.getUrl());
      String json = coneccion.conectar();

      AdaptaJson adaptador = new AdaptaJson();
      Rate rate = adaptador.fromJson(json);

      Calculo calculo = new Calculo(rate.conversion_rate());

      System.out.println("Ingrese monto:");
      monto = teclado.nextDouble();

      double valorFinal= calculo.calcular(monto);
      System.out.println("Resultado: "+valorFinal);

    }while (opcion !=7);

  }


}
