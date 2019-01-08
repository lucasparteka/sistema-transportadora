package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListVeiculos implements Serializable{
    
     List<Veiculo> listaVeiculos = new ArrayList<>();

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    
    public Veiculo getVeiculo() {
        return listaVeiculos.get(0);
    }

    public void setVeiculo(Veiculo veiculo) {
        this.listaVeiculos.add(veiculo);
    }
    
}
