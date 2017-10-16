package com.example.ricardo.zapchallenge;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ricardo on 08/10/2017.
 */

class Endereco {
    @SerializedName("Logradouro")
    private String logradouro;
    @SerializedName("Numero")
    private String numero;
    @SerializedName("Complemento")
    private String complemento;
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

    public String getLogradouro() { return logradouro; }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() { return complemento; }

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
