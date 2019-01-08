package dao.arquivo;

import dao.Desserializador;
import dao.Serializador;
import dao.VeiculoDao;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ListVeiculos;
import model.Veiculo;
import util.StatusVeiculo;

public class VeiculoArquivoDAO implements VeiculoDao {

    Serializador serializador;
    Desserializador desserializador;
    ListVeiculos listVeiculos;
    File file = new File("arquivos\\veiculo\\veiculos");

    @Override
    public void salvarVeiculo(Veiculo veiculo) {

        listVeiculos = new ListVeiculos();
        serializador = new Serializador();
        desserializador = new Desserializador();
        try {
            if (file.length() == 0) {
                listVeiculos.setVeiculo(veiculo);
                serializador.serializarObjeto(listVeiculos, file);
            } else {
                listVeiculos = (ListVeiculos) desserializador.desserializar(file);
                listVeiculos.setVeiculo(veiculo);
                serializador.serializarObjeto(listVeiculos, file);
            }
        } catch (Exception ex) {
            Logger.getLogger(VeiculoArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Veiculo> listarVeiculos(int opcao) {
        listVeiculos = new ListVeiculos();
        List<Veiculo> arrayVeiculos = new ArrayList<>();
        desserializador = new Desserializador();
        listVeiculos = (ListVeiculos) desserializador.desserializar(file);

        //opcao 1 - retorna todos os veiculos
        // opcao 2 - retorna somente veiculos com status disponivel
        if (opcao == 1) {
            arrayVeiculos = listVeiculos.getListaVeiculos();
        } else if (opcao == 2) {
            for (Veiculo veiculo : listVeiculos.getListaVeiculos()) {
                if (veiculo.getStatusVeiculo() == StatusVeiculo.LIVRE) {
                    arrayVeiculos.add(veiculo);
                }
            }
        }
        return arrayVeiculos;
    }

    @Override
    public int buscarIdVeiculo(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarStatusVeiculo(String placa, StatusVeiculo status) {
        serializador = new Serializador();
        desserializador = new Desserializador();
        listVeiculos = (ListVeiculos) desserializador.desserializar(file);
        for (int i = 0; i < listVeiculos.getListaVeiculos().size(); i++) {
            if (listVeiculos.getListaVeiculos().get(i).getPlacaVeiculo().equals(placa)) {
                listVeiculos.getListaVeiculos().get(i).setStatusVeiculo(status);
                break;
            }
        }
        serializador.serializarObjeto(listVeiculos, file);
    }

}
