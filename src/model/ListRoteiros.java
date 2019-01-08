package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListRoteiros implements Serializable{
    
    List<Roteiro> listaRoteiros = new ArrayList<>();

    public List<Roteiro> getLista() {
        return listaRoteiros;
    }
    
    public Roteiro getRoteiro() {
        return listaRoteiros.get(0);
    }

    public void setRoteiro(Roteiro roteiro) {
        this.listaRoteiros.add(roteiro);
    }
    
    
    
}
