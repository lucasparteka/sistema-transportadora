/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.arquivo;

import dao.DaoFactory;
import dao.EncomendaDAO;
import dao.MotoristaDao;
import dao.RoteiroDao;
import dao.VeiculoDao;

/**
 *
 * @author Natan
 */
public class ArquivoDaoFactory extends DaoFactory {

    @Override
    public MotoristaDao getMotoristaDao() {
        return new MotoristaArquivoDAO();
    }

    @Override
    public VeiculoDao getVeiculoDao() {
        return new VeiculoArquivoDAO();
    }

    @Override
    public EncomendaDAO getEncomendaDao() {
        return new EncomendaArquivoDAO();
    }

    @Override
    public RoteiroDao getRoteiroDAO() {
        return new RoteiroArquivoDAO();
    }
    
}
