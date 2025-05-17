package com.conversor.Clases;

import java.time.LocalDateTime;

public class Transaccion {
  private final String base;
  private final String target;

  private double amount;
  private double rate;
  private double result;

  private String date;


  public Transaccion(String base, String target, double monto, double rate, double result){
    this.base= base;
    this.target= target;

    this.amount = monto;
    this.rate = rate;
    this.result = result;

    setDate();
  }

  public void setDate() {
    this.date = String.valueOf(LocalDateTime.now());
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public void setResult(double result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "Transaccion{" +
            "base='" + base + '\'' +
            ", target='" + target + '\'' +
            ", amount=" + amount +
            ", rate=" + rate +
            ", result=" + String.format("%.2f",result)  +
            ", date='" + date + '\'' +
            '}';
  }
}
