package com.conversor.calculo;

public class Calculo {

  private double conversionRate;


  public Calculo(double conversionRate){
    this.conversionRate = conversionRate;
  }

  public double calcular(double monto){
    return monto * conversionRate;
  }
}
