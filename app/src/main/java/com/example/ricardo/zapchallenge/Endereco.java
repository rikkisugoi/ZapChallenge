package com.example.ricardo.zapchallenge;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ricardo on 08/10/2017.
 */

class Endereco {
    @SerializedName("Numero")
    private String numero;
    @SerializedName("CEP")
    private String CEP;
    @SerializedName("Bairro")
    private String bairro;
    @SerializedName("Cidade")
    private String cidade;
    @SerializedName("Estado")
    private String estado;
    @SerializedName("Zona")
    private String zona;

    public Endereco(String numero, String CEP, String bairro, String cidade, String estado, String zona) {
        this.numero = numero;
        this.CEP = CEP;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.zona = zona;
    }

    public String getNumero() {
        return numero;
    }

    public String getCEP() {
        return CEP;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getZona() {
        return zona;
    }
}
