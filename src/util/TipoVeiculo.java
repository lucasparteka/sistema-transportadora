package util;

import java.io.Serializable;

public enum TipoVeiculo implements Serializable {
    VAN(1, 1), BAU(3, 2), CARRETA(10, 3);

    private final int capacidade;
    private final int id;

    TipoVeiculo(int valor, int idVeiculo) {
        capacidade = valor;
        id = idVeiculo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getId() {
        return id;
    }

}
