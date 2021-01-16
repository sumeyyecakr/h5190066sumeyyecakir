package com.h5190066.sumeyye_cakir_final.util;

import com.google.gson.Gson;
import com.h5190066.sumeyye_cakir_final.model.MakyajModel;



public class ObjectUtil {
    public  static String makyajToJsonString(MakyajModel makyajModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(makyajModel);
    }
    public  static MakyajModel jsonStringToMakyaj(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,MakyajModel.class);
    }
}