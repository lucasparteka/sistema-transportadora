package dao.arquivo;

import dao.Desserializador;
import dao.MotoristaDao;
import dao.Serializador;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.ListMotoristas;
import model.Motorista;
import util.StatusMotorista;

public class MotoristaArquivoDAO implements MotoristaDao {

    private Serializador serializador;
    private Desserializador desserializador;
    private ListMotoristas listMotoristas;
    private File file = new File("arquivos\\motorista\\motoristas");

    @Override
    public boolean salvarMotorista(Motorista motorista) {

        listMotoristas = new ListMotoristas();
        serializador = new Serializador();
        desserializador = new Desserializador();
        try {
            if (file.length() == 0) {
                listMotoristas.setMotorista(motorista);
                serializador.serializarObjeto(listMotoristas, file);
            } else {
                listMotoristas = (ListMotoristas) desserializador.desserializar(file);
                listMotoristas.setMotorista(motorista);
                serializador.serializarObjeto(listMotoristas, file);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Motorista> listarMotoristas(int opcao) {
        List<Motorista> arrayMotoristas = new ArrayList<>();
        desserializador = new Desserializador();
        listMotoristas = new ListMotoristas();
        listMotoristas = (ListMotoristas) desserializador.desserializar(file);

        //opcao 1 - tras todos os motoristas
        //opcao 2 - tras motoristas com status disponivel
        if (opcao == 1) {
            arrayMotoristas = listMotoristas.getListaMotorista();
        } else if (opcao == 2) {
            for (Motorista motorista : listMotoristas.getListaMotorista()) {
                if (motorista.getStatusTrabalho() == StatusMotorista.DISPONIVEL) {
                    arrayMotoristas.add(motorista);
                }
            }
        }
        return arrayMotoristas;
    }

    @Override
    public int buscarIdMotorista(String cnh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarNumeroCNH(String numeroCNH) {
        desserializador = new Desserializador();
        listMotoristas = (ListMotoristas) desserializador.desserializar(file);
        for (int i = 0; i < listMotoristas.getListaMotorista().size(); i++) {
            if (listMotoristas.getListaMotorista().get(i).getNumeroCnh().equals(numeroCNH)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void alterarStatusMotorista(String cnh, StatusMotorista status) {
        serializador = new Serializador();
        desserializador = new Desserializador();
        listMotoristas = (ListMotoristas) desserializador.desserializar(file);
        for (int i = 0; i < listMotoristas.getListaMotorista().size(); i++) {
            if (listMotoristas.getListaMotorista().get(i).getNumeroCnh().equals(cnh)) {
                listMotoristas.getListaMotorista().get(i).setStatusTrabalho(status);
                break;
            }
        }
        serializador.serializarObjeto(listMotoristas, file);
    }

}
