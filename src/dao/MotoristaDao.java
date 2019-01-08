package dao;

import java.util.List;
import model.Motorista;
import util.StatusMotorista;

public interface MotoristaDao {

    public int buscarIdMotorista(String cnh);
    
    public boolean salvarMotorista(Motorista motorista);
    
    public List<Motorista> listarMotoristas(int opcao);
    
    public boolean verificarNumeroCNH(String numeroCNH);
    
    public void alterarStatusMotorista(String cnh, StatusMotorista status);
}
