package controller;

import dao.DaoFactory;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Encomenda;
import model.Roteiro;
import util.StatusEncomenda;
import util.StatusMotorista;
import util.StatusRoteiro;
import util.StatusVeiculo;
import view.Home;

public class RoteiroController {

    DaoFactory daoFactory = Home.getDaoFactory();
    private Roteiro roteiro;
    public boolean gerarRoteiro(String cnhMotorista, String placaVeiculo, int quantidadeEncomendas) {
        roteiro = new Roteiro();
        //Pega as encomendas de acordo com a quantidade informada na tela de gerar roteiro. Vem por ordem correta de prioridade
        List<Encomenda> subList = new ArrayList<Encomenda>(daoFactory.getEncomendaDao().retornarEncomendas().subList(0, quantidadeEncomendas));

        //altera o status das encomendas selecionadas para em andamento 
        for (Encomenda encomenda : subList) {
            alterarStatusEncomenda(encomenda.getCodigoEncomenda(), StatusEncomenda.EM_ANDAMENTO);
        }
        
        //chama o metodo para alterar o status do motorista.
        alterarStatusMotorista(cnhMotorista, StatusMotorista.TRABALHANDO);
        
        //chama o metodo para alterar o status do veiculo.
        alterarStatusVeiculo(placaVeiculo, StatusVeiculo.OCUPADO);
        
        roteiro.setArrayEncomendas(subList);
        roteiro.setMotoristaVinculado(cnhMotorista);
        roteiro.setVeiculoVinculado(placaVeiculo);
        roteiro.setStatusRoteiro(StatusRoteiro.ABERTO);

        //pega a data atual do pc
        DateTimeFormatter dataRoteiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAgora = LocalDate.now();
        String data = dataRoteiro.format(dataAgora);
        roteiro.setDataRoteiro(data);

        return daoFactory.getRoteiroDAO().gerarRoteiro(roteiro, quantidadeEncomendas);
    }
    
    public boolean finalizarRoteiro(int codigoRoteiro, String cnhMotorista, String placaVeiculo){
        alterarStatusMotorista(cnhMotorista, StatusMotorista.DISPONIVEL);
        alterarStatusVeiculo(placaVeiculo, StatusVeiculo.LIVRE);
        return daoFactory.getRoteiroDAO().finalizarRoteiro(codigoRoteiro);
    }

    public List<Roteiro> retornaRoteirosEmAberto() {
        return daoFactory.getRoteiroDAO().retornaRoteiros(2);
    }

    public List<Encomenda> retornaEncomendasRoteiro(int codigoRoteiro) {
        return daoFactory.getRoteiroDAO().retornaEncomendasRoteiro(codigoRoteiro);
    }

    public void alterarStatusEncomenda(int codigoEncomenda, StatusEncomenda status) {
        daoFactory.getEncomendaDao().alterarStatusEncomenda(codigoEncomenda, status);
    }

    public void alterarStatusMotorista(String cnh, StatusMotorista status) {
        daoFactory.getMotoristaDao().alterarStatusMotorista(cnh, status);
    }
    
    public void alterarStatusVeiculo(String placa, StatusVeiculo status){
        daoFactory.getVeiculoDao().alterarStatusVeiculo(placa, status);
    }
}
