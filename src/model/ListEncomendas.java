package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListEncomendas implements Serializable{
    
    List<Encomenda> listaEncomendas = new ArrayList<>();

    public List<Encomenda> getLista() {
        return listaEncomendas;
    }
    
    public Encomenda getEncomenda() {
        return listaEncomendas.get(0);
    }

    public void setEncomenda(Encomenda encomenda) {
        this.listaEncomendas.add(encomenda);
    }
    
}
