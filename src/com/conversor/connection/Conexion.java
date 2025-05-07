package com.conversor.connection;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {

  private String url;

  public Conexion(String base, String target){
    this.url = "https://v6.exchangerate-api.com/v6/5d582a3e90a3fe9f06ff09fa/pair/"+base+"/"+target;
  }

  public String conectar (){
    String json = "";

    try{
      HttpClient cliente = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(this.url))
              .build();

      HttpResponse<String> res = cliente
              .send(request, HttpResponse.BodyHandlers.ofString());

      json = res.body();

    }catch (Exception e){
      System.out.println(e.getMessage());
    }

    return json;
  }

  public String getUrl() {
    return url;
  }
}
