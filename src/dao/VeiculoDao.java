package dao;

import java.util.List;
import model.Veiculo;
import util.StatusVeiculo;

public interface VeiculoDao {

    public void salvarVeiculo(Veiculo veiculo);

    public List<Veiculo> listarVeiculos(int opcao);

    public int buscarIdVeiculo(String placa);
    
    public void alterarStatusVeiculo(String placa, StatusVeiculo status);
}
