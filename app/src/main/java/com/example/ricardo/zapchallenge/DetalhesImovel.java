package com.example.ricardo.zapchallenge;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.http.Url;

/**
 * Created by Ricardo on 08/10/2017.
 */

class DetalhesImovel {
    @SerializedName("CodImovel")
    private int codImovel;
    @SerializedName("TipoImovel")
    private String tipoImovel;
    @SerializedName("Endereco")
    private Endereco endereco;
    @SerializedName("PrecoVenda")
    private double precoVenda;
    @SerializedName("Dormitorios")
    private int dormitorios;
    @SerializedName("Suites")
    private int suites;
    @SerializedName("Vagas")
    private int vagas;
    @SerializedName("AreaUtil")
    private double areaUtil;
    @SerializedName("AreaTotal")
    private double areaTotal;
    @SerializedName("DataAtualizacao")
    private String dataAtualizacao;
    @SerializedName("Cliente")
    private Cliente cliente;
    @SerializedName("UrlImagem")
    private String urlImagem;
    @SerializedName("Fotos")
    private ArrayList<String> fotos;
    @SerializedName("SubTipoOferta")
    private String subTipoOferta;
    @SerializedName("Observacao")
    private String observacao;
    @SerializedName("Caracteristicas")
    private ArrayList<String> caracteristicas;
    @SerializedName("PrecoCondominio")
    private double precoCondominio;
    @SerializedName("SubtipoImovel")
    private String subTipoImovel;
    @SerializedName("CaracteristicasComum")
    private ArrayList<String> caracteristicasComum;
    @SerializedName("InformacoesComplementares")
    private String informacoesComplementares;

    public int getCodImovel() {
        return codImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public int getSuites() {
        return suites;
    }

    public int getVagas() {
        return vagas;
    }

    public double getAreaUtil() {
        return areaUtil;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public ArrayList<String> getFotos() {
        return fotos;
    }

    public String getSubTipoOferta() {
        return subTipoOferta;
    }

    public String getObservacao() {
        return observacao;
    }

    public ArrayList<String> getCaracteristicas() {
        return caracteristicas;
    }

    public double getPrecoCondominio() {
        return precoCondominio;
    }

    public String getSubTipoImovel() {
        return subTipoImovel;
    }

    public ArrayList<String> getCaracteristicasComum() {
        return caracteristicasComum;
    }

    public String getInformacoesComplementares() {
        return informacoesComplementares;
    }
}
