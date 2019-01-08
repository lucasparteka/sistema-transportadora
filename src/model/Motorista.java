package model;

import java.io.Serializable;
import util.StatusMotorista;
import util.TipoCNH;

public class Motorista implements Serializable {
    
    private String nomeMotorista;
    private String dataNascimento;
    private Endereco enderecoMotorista;
    private String numeroCnh;
    private TipoCNH categoriaCnh;
    private StatusMotorista statusTrabalho;

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEnderecoMotorista() {
        return enderecoMotorista;
    }

    public void setEnderecoMotorista(Endereco enderecoMotorista) {
        this.enderecoMotorista = enderecoMotorista;
    }

    public String getNumeroCnh() {
        return numeroCnh;
    }

    public void setNumeroCnh(String numeroCnh) {
        this.numeroCnh = numeroCnh;
    }

    public TipoCNH getCategoriaCnh() {
        return categoriaCnh;
    }

    public void setCategoriaCnh(TipoCNH categoriaCnh) {
        this.categoriaCnh = categoriaCnh;
    }

    public StatusMotorista getStatusTrabalho() {
        return statusTrabalho;
    }

    public void setStatusTrabalho(StatusMotorista statusTrabalho) {
        this.statusTrabalho = statusTrabalho;
    }
    
}
