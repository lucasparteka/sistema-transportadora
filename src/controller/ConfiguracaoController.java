package controller;

import dao.bd.ConfiguracaoDAO;
import java.sql.Date;

public class ConfiguracaoController {
    
    ConfiguracaoDAO configuracao = new ConfiguracaoDAO();
    
    public void gravarUltimoDiaUsoSistema(Date ultimoUso){
        configuracao.gravarUltimoDiaUsoSistema(ultimoUso);
    }
    
    public Date retornaUltimoDiaUsoSistema(){
        return configuracao.retornaUltimoDiaUsoSistema();
    }
    
}
