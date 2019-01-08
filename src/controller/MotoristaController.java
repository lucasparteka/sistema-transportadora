package controller;

import dao.DaoFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import model.Motorista;
import view.Home;

public class MotoristaController {

    DaoFactory daoFactory = Home.getDaoFactory();

    public boolean salvarMotorista(Motorista motorista) {
        boolean resultado = false;
        try {
            resultado = daoFactory.getMotoristaDao().salvarMotorista(motorista);
        } catch (Exception ex) {
            Logger.getLogger(MotoristaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public List<Motorista> listarMotoristas(int opcao) {
        return daoFactory.getMotoristaDao().listarMotoristas(opcao);

    }

    public boolean verificarCnhRepetida(String numeroCNH) {
        boolean resultado = false;
        try {
            resultado = daoFactory.getMotoristaDao().verificarNumeroCNH(numeroCNH);
        } catch (Exception ex) {
            Logger.getLogger(MotoristaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
}
