package com.conversor.connection;

import com.conversor.Clases.Transaccion;
import com.conversor.TDOs.Rate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class AdaptaJson {
  private Gson gson;

  public AdaptaJson(){
    this.gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
  }

  public Rate fromJson (String json){
    return this.gson.fromJson(json, Rate.class);
  }

  public String toJson (List<Transaccion> transacciones){
    return  formatJson(this.gson.toJson(transacciones));
  }

  public String formatJson(String uglyJson){
    JsonElement jsonElement = JsonParser.parseString(uglyJson);
    return this.gson.toJson(jsonElement);
  }
}
