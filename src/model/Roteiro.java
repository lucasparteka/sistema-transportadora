package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import util.StatusRoteiro;

public class Roteiro implements Serializable {
    
private String dataRoteiro;
private String placaVeiculoVinculado;
private String cnhMotoristaVinculado;
private int codigoIdentificador;
private StatusRoteiro statusRoteiro;
private List<Encomenda> encomendasVinculadas = new ArrayList<>();


    public StatusRoteiro getStatusRoteiro() {
        return statusRoteiro;
    }

    public void setStatusRoteiro(StatusRoteiro statusFeedback) {
        this.statusRoteiro = statusFeedback;
    }

    public int getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(int codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public String getDataRroteiro() {
        return dataRoteiro;
    }

    public void setDataRoteiro(String dataRoteiro) {
        this.dataRoteiro = dataRoteiro;
    }

    public String getVeiculoVinculado() {
        return placaVeiculoVinculado;
    }

    public void setVeiculoVinculado(String veiculoVinculado) {
        this.placaVeiculoVinculado = veiculoVinculado;
    }

    public String getMotoristaVinculado() {
        return cnhMotoristaVinculado;
    }

    public void setMotoristaVinculado(String motoristaVinculado) {
        this.cnhMotoristaVinculado = motoristaVinculado;
    }

    public List<Encomenda> getListaEncomendas() {
        return encomendasVinculadas;
    }
    
    public Encomenda getEncomenda() {
        return encomendasVinculadas.get(0);
    }

    public void setEncomendas(Encomenda encomenda) {
        this.encomendasVinculadas.add(encomenda);
    }
    
    public void setArrayEncomendas(List<Encomenda> listaEncomenda) {
        this.encomendasVinculadas = listaEncomenda;
    }

}
