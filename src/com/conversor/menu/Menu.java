package com.conversor.menu;

import com.conversor.Clases.Archivo;
import com.conversor.Clases.Transaccion;
import com.conversor.calculo.Calculo;
import com.conversor.connection.AdaptaJson;
import com.conversor.connection.Conexion;
import com.conversor.TDOs.Rate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

  private String base;
  private String target;
  private Calculo calculo;
  private final AdaptaJson adaptador = new AdaptaJson();
  private Rate rate;
  private Archivo archivo = new Archivo();

  public void run(){
    Scanner teclado = new Scanner(System.in);

    int opcion = 0;
    double monto;
    List<Transaccion> transaccionList = new ArrayList<>();

    while (opcion != 8){

      mostrarOpcionesMenu();

      opcion = teclado.nextInt();
      if(opcion == 8 ){
        System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta Pronto!");
        break;
      }

      elegirOpcionDeMenu(opcion); ///SWITCH

      if(opcion !=7 ){

        obtenerCalculo();

        System.out.println("Ingrese monto:");
        monto = teclado.nextDouble();

        double valorFinal= this.calculo.calcular(monto);
        System.out.println("Resultado: "+ String.format("%.2f",valorFinal) );

        Transaccion transaccion = new Transaccion(this.base,this.target, monto, this.rate.conversion_rate(),valorFinal);
        transaccionList.add(transaccion);


        try{
          this.archivo.guardarJson(adaptador.toJson(transaccionList));
        } catch (IOException e) {
          System.out.println("Error al guardar las transacciones: "+ e.getMessage());
        }
        catch (Exception e) {
          System.out.println("Error inesperado: "+e.getMessage());;
        }
      }else {
        System.out.println("No hay transacciones a guardar");
      }

    }




  }


  private void obtenerCalculo(){
    Conexion coneccion = new Conexion(this.base,this.target);
    String json = coneccion.conectar();

    this.rate = adaptador.fromJson(json);
    this.calculo = new Calculo(rate.conversion_rate());
  }


  private void setBaseTarget(String base, String target) {
    this.base = base;
    this.target = target;
  }


  private void mostrarOpcionesMenu(){
    System.out.println("****************************");
    System.out.println("1) Dolar a Peso Argentinto");
    System.out.println("2) Peso Argentinto a Dolar");
    System.out.println("3) Dolar a Euro");
    System.out.println("4) Euro a Dolar");
    System.out.println("5) Peso Argentinto a Euro");
    System.out.println("6) Euro a Peso Argentino");
    System.out.println("7) Mostrar ultimas transacciones");
    System.out.println("8) Salir");
    System.out.println("SELECCIONE UNA OPCION VALIDA");
    System.out.println("****************************");
  }


  private void elegirOpcionDeMenu(int opcion){
    switch (opcion){ /// Crear el constructor para la conexion con la moneda base y la moneda target
      case 1:
        setBaseTarget("USD", "ARS");
        break;
      case 2:
        setBaseTarget("ARS", "USD");
        break;
      case 3:
        setBaseTarget("USD", "EUR");
        break;
      case 4:
        setBaseTarget("EUR", "USD");
        break;
      case 5:
        setBaseTarget("ARS", "EUR");
        break;
      case 6:
        setBaseTarget("EUR", "ARS");
        break;
      case 7:
        System.out.println("7");
        try{
          this.archivo.leerArchivo();

        } catch (Exception e) {
          System.out.println("Error al leer el historial: "+ e.getMessage());
        }
        break;
    }
  }
}
