package dao.bd;

import dao.ConnectionFactory;
import dao.RoteiroDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Encomenda;
import model.Roteiro;
import util.StatusRoteiro;

public class RoteiroBancoDAO implements RoteiroDao {

    private Connection connect;

    @Override
    public boolean gerarRoteiro(Roteiro roteiro, int quantidadeCaixas) {

        MotoristaBancoDAO motoristaBancoDAO = new MotoristaBancoDAO();
        int idMotorista = motoristaBancoDAO.buscarIdMotorista(roteiro.getMotoristaVinculado());

        VeiculoBancoDAO veiculoBancoDAO = new VeiculoBancoDAO();
        int idVeiculo = veiculoBancoDAO.buscarIdVeiculo(roteiro.getVeiculoVinculado());

        //System.out.println(roteiro.getCodigoIdentificador() + "===" + idMotorista + "===" + idVeiculo + "===" + roteiro.getDataRroteiro() + "===" + roteiro.getListaEncomendas().size());
        boolean resultado = false;
        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet result = null;
        String sql = "With rows AS(\n"
                + "INSERT INTO public.roteiro(\n"
                + "motorista, veiculo, data_rota, status_roteiro)\n"
                + "VALUES (?, ?, ?, ?) RETURNING id)\n"
                + "SELECT id \n"
                + "FROM rows";
        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, idMotorista);
            stat.setInt(2, idVeiculo);
            stat.setString(3, roteiro.getDataRroteiro());
            stat.setInt(4, 1);
            result = stat.executeQuery();
            while (result.next()) {
                roteiro.setCodigoIdentificador(result.getInt("id"));
                resultado = true;
            }
        } catch (SQLException e) {
            System.err.print(e);

        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        JOptionPane.showMessageDialog(null, roteiro.getCodigoIdentificador());

        //chama o metodo para setar os ids das encomendas na tabela de relação
        for (Encomenda encomenda : roteiro.getListaEncomendas()) {
            adicionarEncomendaRelacao(encomenda.getCodigoEncomenda(), roteiro.getCodigoIdentificador());
        }
        return resultado;
    }

    public boolean adicionarEncomendaRelacao(int idEncomenda, int idRoteiro) {
        boolean resultado = false;
        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        String sql = "INSERT INTO public.relacao_encomenda(\n"
                + "id_roteiro, id_encomenda)\n"
                + "VALUES (?, ?);";

        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, idRoteiro);
            stat.setInt(2, idEncomenda);
            stat.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            System.err.println("erro no metodo adicionar encomenda na relação");

        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
        return resultado;
    }

    @Override
    public List<Roteiro> retornaRoteiros(int opcao) {
        List<Roteiro> listaRoteiros = new ArrayList<>();
        Roteiro roteiro;
        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet result = null;
        String sql = "";

        //opcao 1 retorna todos os roteiros
        // opcao 2 retorna somente roteiros em aberto
        if (opcao == 1) {
            sql = "SELECT ro.id, ro.data_rota as data, mot.numero_cnh as motorista, vel.placa FROM roteiro ro\n"
                    + "JOIN motorista mot ON mot.id = ro.motorista\n"
                    + "JOIN veiculo vel ON vel.id = ro.veiculo";
        } else if (opcao == 2) {
            sql = "SELECT ro.id, ro.data_rota as data, mot.numero_cnh as motorista, vel.placa FROM roteiro ro\n"
                    + "JOIN motorista mot ON mot.id = ro.motorista\n"
                    + "JOIN veiculo vel ON vel.id = ro.veiculo\n"
                    + "WHERE ro.status_roteiro = 1";
        }

        try {
            stat = connect.prepareStatement(sql);
            result = stat.executeQuery();
            while (result.next()) {
                roteiro = new Roteiro();
                roteiro.setCodigoIdentificador(result.getInt("id"));
                roteiro.setDataRoteiro(result.getString("data"));
                roteiro.setMotoristaVinculado(result.getString("motorista"));
                roteiro.setVeiculoVinculado(result.getString("placa"));
                listaRoteiros.add(roteiro);
            }

        } catch (SQLException e) {
            System.err.println("erro no metodo adicionar encomenda na relação");

        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return listaRoteiros;
    }

    @Override
    public List<Encomenda> retornaEncomendasRoteiro(int codigoRoteiro) {
        List<Encomenda> listaEncomendas = new ArrayList<>();
        Encomenda encomenda;
        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet result = null;
        String sql = "SELECT en.codigo_encomenda as codigo, en.peso, en.data_postagem \n"
                + "FROM relacao_encomenda re\n"
                + "JOIN encomenda en ON re.id_encomenda = en.codigo_encomenda\n"
                + "WHERE id_roteiro = ?";

        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, codigoRoteiro);
            result = stat.executeQuery();
            while (result.next()) {
                encomenda = new Encomenda();
                encomenda.setCodigoEncomenda(result.getInt("codigo"));
                encomenda.setDataPostagem(result.getString("data_postagem"));
                encomenda.setPeso(result.getDouble("peso"));
                listaEncomendas.add(encomenda);
            }

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return listaEncomendas;
    }

    @Override
    public boolean finalizarRoteiro(int codigoRoteiro) {
        boolean resultado = false;
        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        String sql = "UPDATE roteiro \n"
                + "SET status_roteiro = ? \n"
                + "WHERE id = ?";

        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, StatusRoteiro.FECHADO.getValorStatus());
            stat.setInt(2, codigoRoteiro);
            stat.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
        return resultado;

    }

}
