package com.conversor.connection;

import com.conversor.records.Rate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AdaptaJson {
  private Gson gson;

  public AdaptaJson(){
    this.gson = new GsonBuilder()
            .create();
  }

  public Rate fromJson (String json){
    return this.gson.fromJson(json, Rate.class);
  }


}
