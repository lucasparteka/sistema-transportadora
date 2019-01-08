package dao;

import dao.arquivo.ArquivoDaoFactory;
import dao.bd.BancoDaoFactory;
import javax.swing.JOptionPane;

public abstract class DaoFactory {
    //1 - Banco 
    //2 - Arquivo
    public static DaoFactory getDaoFactory(int opcao) {
        if(opcao == 1) {
            return new BancoDaoFactory();
        } else if(opcao == 2){
            return new ArquivoDaoFactory();
        } else {
            JOptionPane.showMessageDialog(null, "opcao invalida");
        }
        return null;
    }
    
    public abstract MotoristaDao getMotoristaDao();
    
    public abstract VeiculoDao getVeiculoDao();
    
    public abstract EncomendaDAO getEncomendaDao();
    
    public abstract RoteiroDao getRoteiroDAO();
    
}
