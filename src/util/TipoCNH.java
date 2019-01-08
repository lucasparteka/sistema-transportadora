package util;

import java.io.Serializable;

public enum TipoCNH implements Serializable{
    
    C(3, "C"), B(1, "B");
	
	public int valorTipoCNH;
        public String letraCategoria;
	
	TipoCNH(int valor, String letra){
		valorTipoCNH = valor;
                letraCategoria = letra;
	}
        
        public String getLetraCategoria(){
            return letraCategoria;
        }

	public int getValorCNH() {
		return valorTipoCNH;
	}
}
