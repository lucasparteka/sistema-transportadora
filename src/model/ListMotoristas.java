package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListMotoristas implements Serializable{
    
    List<Motorista> listaMotorista = new ArrayList<>();

    public List<Motorista> getListaMotorista() {
        return listaMotorista;
    }
    
    public Motorista getMotorista() {
        return listaMotorista.get(0);
    }

    public void setMotorista(Motorista motorista) {
        this.listaMotorista.add(motorista);
    }
    
}
