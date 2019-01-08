package controller;

import dao.DaoFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Encomenda;
import java.util.Random;
import view.Home;

public class EncomendaController {

    DaoFactory daoFactory = Home.getDaoFactory();

    public boolean verificarCodigoEncomenda(int codigoCaixa) {
        return daoFactory.getEncomendaDao().verificarCodigoEncomenda(codigoCaixa);
    }

    public boolean adicionarEncomenda(Encomenda encomenda) {
        boolean salvou = false;
        try {
           salvou = daoFactory.getEncomendaDao().adicionarEncomenda(encomenda);
        } catch (Exception ex) {
            Logger.getLogger(EncomendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salvou;
    }

    public List<Encomenda> retornaEncomendas() {
        return daoFactory.getEncomendaDao().retornarEncomendas();
    }

    public int gerarCodigoAleatorio() {

        String caracteresPermitidos = "0123456789";
        Random random = new Random();

        String codigoAleatorio = "";
        int index = -1;

        for (int i = 0; i < 5; i++) {
            index = random.nextInt(caracteresPermitidos.length());
            codigoAleatorio += caracteresPermitidos.substring(index, index + 1);
        }
        return Integer.parseInt(codigoAleatorio);
    }
    
    public void alterarStatusEncomendaPendente(){
        daoFactory.getEncomendaDao().alterarStatusEncomendaPendente();
    }

}
