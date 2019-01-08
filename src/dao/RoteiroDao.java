package dao;

import java.util.List;
import model.Encomenda;
import model.Roteiro;

public interface RoteiroDao {
    
    public boolean gerarRoteiro(Roteiro roteiro, int quantidadeCaixas);
    
    public List<Roteiro> retornaRoteiros (int opcao);
    
    public List<Encomenda> retornaEncomendasRoteiro (int codigoRoteiro);
    
    public boolean finalizarRoteiro(int codigoRoteiro);
    
}
