/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bd;

import dao.DaoFactory;
import dao.EncomendaDAO;
import dao.MotoristaDao;
import dao.RoteiroDao;
import dao.VeiculoDao;

/**
 *
 * @author Natan
 */
public class BancoDaoFactory extends DaoFactory {

    @Override
    public MotoristaDao getMotoristaDao() {
        return new MotoristaBancoDAO();
    }

    @Override
    public VeiculoDao getVeiculoDao() {
        return new VeiculoBancoDAO();
    }

    @Override
    public EncomendaDAO getEncomendaDao() {
        return new EncomendaBancoDAO();
    }

    @Override
    public RoteiroDao getRoteiroDAO() {
        return new RoteiroBancoDAO();
    }
    
}
