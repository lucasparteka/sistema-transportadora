/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public enum StatusVeiculo implements Serializable{
    LIVRE(1), OCUPADO(2);
	
	public int valorStatus;
	
	StatusVeiculo(int valor){
		valorStatus = valor;
	}
	
	public int getValorStatus() {
		return valorStatus;
	}
}
