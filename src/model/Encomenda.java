package model;

import java.io.Serializable;
import util.StatusEncomenda;

public class Encomenda implements Serializable {

    private String dataPostagem;
    private int codigoEncomenda;
    private Double peso;
    private String nomeRemetente;
    private String nomeDestinatario;
    private Endereco enderecoRemetente;
    private Endereco enderecoRestinatario;
    private StatusEncomenda statusEncomenda;

    public int getCodigoEncomenda() {
        return codigoEncomenda;
    }

    public void setCodigoEncomenda(int codigoEncomenda) {
        this.codigoEncomenda = codigoEncomenda;
    }

    public Endereco getEnderecoRestinatario() {
        return enderecoRestinatario;
    }

    public void setEnderecoRestinatario(Endereco enderecoRestinatario) {
        this.enderecoRestinatario = enderecoRestinatario;
    }

    public String getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(String dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public Endereco getEnderecoRemetente() {
        return enderecoRemetente;
    }

    public void setEnderecoRemetente(Endereco endereco_remetente) {
        this.enderecoRemetente = endereco_remetente;
    }

    public Endereco getEnderecoDestinatario() {
        return enderecoRestinatario;
    }

    public void setEnderecoDestinatario(Endereco endereco_destinatario) {
        this.enderecoRestinatario = endereco_destinatario;
    }

    public StatusEncomenda getStatusEncomenda() {
        return statusEncomenda;
    }

    public void setStatusEncomenda(StatusEncomenda status_encomenda) {
        this.statusEncomenda = status_encomenda;
    }
    
    
    
    
}
