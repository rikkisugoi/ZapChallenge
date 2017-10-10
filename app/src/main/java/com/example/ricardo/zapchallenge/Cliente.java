package com.example.ricardo.zapchallenge;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ricardo on 08/10/2017.
 */

class Cliente {
    @SerializedName("CodCliente")
    public int codCliente;
    @SerializedName("NomeFantasia")
    public String nomeFantasia;

    public Cliente(int codCliente, String nomeFantasia) {
        this.codCliente = codCliente;
        this.nomeFantasia = nomeFantasia;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}
