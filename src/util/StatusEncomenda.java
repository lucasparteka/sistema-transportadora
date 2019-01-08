package util;

import java.io.Serializable;

public enum StatusEncomenda implements Serializable {
    NAO_ENTREGUE(1, "NÃO ENTREGUE"), PENDENTE(2, "PENDENTE"), AGUARDANDO(3, "AGUARDANDO"),  ENTREGUE(4, "ENTREGUE"), EM_ANDAMENTO(5, "EM ANDAMENTO");
	
	public int valorStatus;
        public String textoStatus;
	
	StatusEncomenda(int valor, String texto){
		valorStatus = valor;
                textoStatus = texto;
	}
	
	public int getValorStatus() {
		return valorStatus;
	}
        
        public String getTextoStatus(){
            return textoStatus;
        }
}
