package com.example.ricardo.zapchallenge;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ricardo on 14/10/2017.
 */

public class Imovel {
    @SerializedName("Imovel")
    private DetalhesImovel imovel;

    public DetalhesImovel getImovel() {
        return imovel;
    }
}
