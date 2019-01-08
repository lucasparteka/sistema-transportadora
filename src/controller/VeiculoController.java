package controller;

import dao.DaoFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import model.Veiculo;
import util.StatusVeiculo;
import util.TipoVeiculo;
import view.Home;

public class VeiculoController {

    DaoFactory daoFactory = Home.getDaoFactory();

    public boolean salvarVeiculo(String placa, String marca, String anoVeiculo, String tipo) {
        boolean result = false;
        try {
            Veiculo veiculo = new Veiculo();
            veiculo.setAnoVeiculo(anoVeiculo);
            veiculo.setCapacidadeCarga(TipoVeiculo.valueOf(tipo).getCapacidade());
            veiculo.setMarcaVeiculo(marca);
            veiculo.setPlacaVeiculo(placa);
            veiculo.setTipoVeiculo(TipoVeiculo.valueOf(tipo));
            veiculo.setStatusVeiculo(StatusVeiculo.LIVRE);
            daoFactory.getVeiculoDao().salvarVeiculo(veiculo);
            result = true;
        } catch (Exception ex) {
            Logger.getLogger(VeiculoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<Veiculo> listarVeiculosDisponiveis(int opcao) {
        return daoFactory.getVeiculoDao().listarVeiculos(opcao);
    }
    
}
