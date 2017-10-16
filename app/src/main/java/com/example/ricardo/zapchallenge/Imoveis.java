package com.example.ricardo.zapchallenge;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 08/10/2017.
 */

public class Imoveis {
    @SerializedName("Imoveis")
    private ArrayList<DetalhesImovel> imoveis;

    public ArrayList<DetalhesImovel> getImoveis() {
        return imoveis;
    }
}
