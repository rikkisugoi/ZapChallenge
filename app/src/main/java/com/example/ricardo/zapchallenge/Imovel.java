package com.example.ricardo.zapchallenge;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.Date;

import retrofit2.http.Url;

/**
 * Created by Ricardo on 08/10/2017.
 */

class Imovel {
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
    private URI urlImagem;
    @SerializedName("SubTipoOferta")
    private String subTipoOferta;
    @SerializedName("SubtipoImovel")
    private String subTipoImovel;

    public Imovel(int codImovel, String tipoImovel, Endereco endereco, double precoVenda, int dormitorios, int suites, int vagas, double areaUtil, double areaTotal, String dataAtualizacao, Cliente cliente, URI urlImagem, String subTipoOferta, String subTipoImovel) {
        this.codImovel = codImovel;
        this.tipoImovel = tipoImovel;
        this.endereco = endereco;
        this.precoVenda = precoVenda;
        this.dormitorios = dormitorios;
        this.suites = suites;
        this.vagas = vagas;
        this.areaUtil = areaUtil;
        this.areaTotal = areaTotal;
        this.dataAtualizacao = dataAtualizacao;
        this.cliente = cliente;
        this.urlImagem = urlImagem;
        this.subTipoOferta = subTipoOferta;
        this.subTipoImovel = subTipoImovel;
    }

    public int getCodImovel() { return codImovel; }

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

    public Cliente getCliente() { return cliente; }

    public URI getUrlImagem() {
        return urlImagem;
    }

    public String getSubTipoOferta() {
        return subTipoOferta;
    }

    public String getSubTipoImovel() {
        return subTipoImovel;
    }
}
