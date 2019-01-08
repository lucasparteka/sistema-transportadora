package util;

import java.io.Serializable;

public enum StatusRoteiro implements Serializable {
    ABERTO(1), FECHADO(2);

    public int valorStatus;

    StatusRoteiro(int valor) {
        valorStatus = valor;
    }

    public int getValorStatus() {
        return valorStatus;
    }
}
