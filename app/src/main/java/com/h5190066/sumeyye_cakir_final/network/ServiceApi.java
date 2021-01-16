package com.h5190066.sumeyye_cakir_final.network;


import com.h5190066.sumeyye_cakir_final.model.MakyajModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("makyaj.json")
    Observable<List<MakyajModel>> makyajlariGetir();
}
