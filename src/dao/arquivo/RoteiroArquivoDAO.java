package dao.arquivo;

import dao.Desserializador;
import dao.RoteiroDao;
import dao.Serializador;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.Encomenda;
import model.ListRoteiros;
import model.Roteiro;
import util.StatusRoteiro;

public class RoteiroArquivoDAO implements RoteiroDao {

    private Desserializador desserializador;
    private Serializador serializador;
    private ListRoteiros listRoteiros;
    private File file = new File("arquivos\\roteiro\\roteiros");

    @Override
    public boolean gerarRoteiro(Roteiro roteiro, int quantidadeCaixas) {

        desserializador = new Desserializador();
        serializador = new Serializador();
        try {
            if (file.length() == 0) {
                listRoteiros = new ListRoteiros();
                roteiro.setCodigoIdentificador(1);
                listRoteiros.setRoteiro(roteiro);
                serializador.serializarObjeto(listRoteiros, file);
            } else {
                listRoteiros = (ListRoteiros) desserializador.desserializar(file);
                roteiro.setCodigoIdentificador(listRoteiros.getLista().size() + 1);
                listRoteiros.setRoteiro(roteiro);
                serializador.serializarObjeto(listRoteiros, file);
            }
            return true;
        } catch (Exception e) {
            System.err.print(e);
            return false;
        }

    }

    @Override
    public List<Roteiro> retornaRoteiros(int opcao) {
        List<Roteiro> listaRoteiros = new ArrayList<>();
        desserializador = new Desserializador();

        //verifica se a pasta roteiro esta vazia
        if (file.length() == 0) {
            return null;
        } else {
            listRoteiros = (ListRoteiros) desserializador.desserializar(file);
            for (Roteiro roteiro : listRoteiros.getLista()) {
                if (roteiro.getStatusRoteiro() == StatusRoteiro.ABERTO) {
                    listaRoteiros.add(roteiro);
                }
            }
        }
        return listaRoteiros;
    }

    @Override
    public List<Encomenda> retornaEncomendasRoteiro(int codigoRoteiro) {
        List<Encomenda> listaEncomendas = new ArrayList<>();
        desserializador = new Desserializador();

        if (file.length() == 0) {
            return null;
        } else {
            listRoteiros = (ListRoteiros) desserializador.desserializar(file);
            for (Roteiro roteiro : listRoteiros.getLista()) {
                if (roteiro.getCodigoIdentificador() == codigoRoteiro) {
                    listaEncomendas = roteiro.getListaEncomendas();
                    break;
                }
            }
        }
        return listaEncomendas;
    }

    @Override
    public boolean finalizarRoteiro(int codigoRoteiro) {

        desserializador = new Desserializador();
        serializador = new Serializador();
        listRoteiros = (ListRoteiros) desserializador.desserializar(file);
        for (int i = 0; i < listRoteiros.getLista().size(); i++) {
            if (listRoteiros.getLista().get(i).getCodigoIdentificador() == codigoRoteiro) {
                listRoteiros.getLista().get(i).setStatusRoteiro(StatusRoteiro.FECHADO);
                serializador.serializarObjeto(listRoteiros, file);
                return true;
            }
        }
        return false;
    }

}
