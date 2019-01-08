/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Encomenda;
import model.Endereco;
import util.StatusEncomenda;

/**
 *
 * @author Natan
 */
public interface EncomendaDAO {

    public List<Endereco> verificarEndereco(int numeroDes, String ruaDes);

    public int buscarIdEndereco(int numero, String rua);

    public boolean adicionarEndereco(String estado, String cidade, String rua, int numero, String complemento, String cep);

    public boolean verificarCodigoEncomenda(int codigoCaixa);

    public boolean adicionarEncomenda(Encomenda encomenda);

    public List<Encomenda> retornarEncomendas();
    
    public void alterarStatusEncomenda(int codigoEncomenda, StatusEncomenda status);
    
    public void alterarStatusEncomendaPendente();

}
