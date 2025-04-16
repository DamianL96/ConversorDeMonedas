package com.conversor.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AdaptaJson {
  private Gson gson;

  public AdaptaJson(){
    this.gson = new GsonBuilder()
            .create();
  }




}
