package com.example.ricardo.zapchallenge;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ricardo on 08/10/2017.
 */

public interface ApiImoveis {
    String BASE_URL = "http://demo4573903.mockable.io/";

    @GET("imoveis")
    Call<Imoveis> getImoveis();

    @GET("imoveis/{CodImovel}")
    Call<Imovel> getImovel(
            @Path("CodImovel")
            int codImovel
    );
}
