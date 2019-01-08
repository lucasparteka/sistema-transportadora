package dao.arquivo;

import dao.Desserializador;
import dao.EncomendaDAO;
import dao.Serializador;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Encomenda;
import model.Endereco;
import model.ListEncomendas;
import util.StatusEncomenda;

public class EncomendaArquivoDAO implements EncomendaDAO {

    Serializador serializador;
    Desserializador desserializador;
    ListEncomendas listEncomendas;
    File file = new File("arquivos\\encomenda\\encomendas");

    @Override
    public List<Endereco> verificarEndereco(int numeroDes, String ruaDes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int buscarIdEndereco(int numero, String rua) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean adicionarEndereco(String estado, String cidade, String rua, int numero, String complemento, String cep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarCodigoEncomenda(int codigoCaixa) {
        listEncomendas = new ListEncomendas();
        desserializador = new Desserializador();
        listEncomendas = (ListEncomendas) desserializador.desserializar(file);

        if (file.length() == 0) {
            return false;
        } else {
            for (Iterator<Encomenda> i = listEncomendas.getLista().iterator(); i.hasNext();) {
                if (i.next().getCodigoEncomenda() == codigoCaixa) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean adicionarEncomenda(Encomenda encomenda) {

        listEncomendas = new ListEncomendas();
        serializador = new Serializador();
        desserializador = new Desserializador();
        try {

            if (file.length() == 0) {
                listEncomendas.setEncomenda(encomenda);
                serializador.serializarObjeto(listEncomendas, file);
            } else {
                listEncomendas = (ListEncomendas) desserializador.desserializar(file);
                listEncomendas.setEncomenda(encomenda);
                serializador.serializarObjeto(listEncomendas, file);
            }

            return true;
        } catch (Exception er) {
            return false;
        }

    }

    @Override
    public List<Encomenda> retornarEncomendas() {
        List<Encomenda> arrayEncomendas = new ArrayList<>();
        desserializador = new Desserializador();
        listEncomendas = (ListEncomendas) desserializador.desserializar(file);

        for (int i = 0; i < listEncomendas.getLista().size(); i++) {
            if (listEncomendas.getLista().get(i).getStatusEncomenda() == StatusEncomenda.NAO_ENTREGUE) {
                arrayEncomendas.add(listEncomendas.getLista().get(i));
            }
        }
        for (int i = 0; i < listEncomendas.getLista().size(); i++) {
            if (listEncomendas.getLista().get(i).getStatusEncomenda() == StatusEncomenda.PENDENTE) {
                arrayEncomendas.add(listEncomendas.getLista().get(i));
            }
        }
        for (int i = 0; i < listEncomendas.getLista().size(); i++) {
            if (listEncomendas.getLista().get(i).getStatusEncomenda() == StatusEncomenda.AGUARDANDO) {
                arrayEncomendas.add(listEncomendas.getLista().get(i));
            }
        }

        return arrayEncomendas;
    }

    @Override
    public void alterarStatusEncomenda(int codigoEncomenda, StatusEncomenda status) {
        serializador = new Serializador();
        desserializador = new Desserializador();
        listEncomendas = (ListEncomendas) desserializador.desserializar(file);
        for (int i = 0; i < listEncomendas.getLista().size(); i++) {
            if (listEncomendas.getLista().get(i).getCodigoEncomenda() == codigoEncomenda) {
                listEncomendas.getLista().get(i).setStatusEncomenda(status);
            }
        }
        serializador.serializarObjeto(listEncomendas, file);
    }

    @Override
    public void alterarStatusEncomendaPendente() {
        serializador = new Serializador();
        desserializador = new Desserializador();
        listEncomendas = (ListEncomendas) desserializador.desserializar(file);
        for (int i = 0; i < listEncomendas.getLista().size(); i++) {
            if (listEncomendas.getLista().get(i).getStatusEncomenda() == StatusEncomenda.AGUARDANDO) {
                listEncomendas.getLista().get(i).setStatusEncomenda(StatusEncomenda.PENDENTE);
            }
        }
        serializador.serializarObjeto(listEncomendas, file);
    }

}
