package dao.bd;

import dao.ConnectionFactory;
import dao.MotoristaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Motorista;
import util.StatusMotorista;
import util.TipoCNH;

public class MotoristaBancoDAO implements MotoristaDao {

    private Connection connect;

    @Override
    public int buscarIdMotorista(String cnh) {
        int idMotorista = 0;
        connect = ConnectionFactory.getConexao();
        String sql = "SELECT id FROM motorista WHERE numero_cnh = ?";
        PreparedStatement stat = null;
        ResultSet result = null;
        try {
            stat = connect.prepareStatement(sql);
            stat.setString(1, cnh);
            result = stat.executeQuery();
            while (result.next()) {
                idMotorista = result.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return idMotorista;
    }

    @Override
    public boolean salvarMotorista(Motorista motorista) {

        EnderecoBancoDAO.adicionarEndereco(motorista.getEnderecoMotorista());
        int idEndereco = EnderecoBancoDAO.buscarIdEndereco(motorista.getEnderecoMotorista().getNumero(), motorista.getEnderecoMotorista().getRua());
        boolean resultado = false;
        connect = ConnectionFactory.getConexao();
        String sql = "INSERT INTO motorista (nome, data_nascimento, numero_cnh, tipo_cnh, endereco_motorista, status_motorista) VALUES (?,?,?,?,?,?);";
        PreparedStatement stat = null;

        try {
            stat = connect.prepareStatement(sql);
            stat.setString(1, motorista.getNomeMotorista());
            stat.setString(2, motorista.getDataNascimento());
            stat.setString(3, motorista.getNumeroCnh());
            stat.setString(4, motorista.getCategoriaCnh().getLetraCategoria());
            stat.setInt(5, idEndereco);
            stat.setInt(6, StatusMotorista.DISPONIVEL.getValorStatus());
            stat.executeUpdate();

            resultado = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
        return resultado;
    }

    @Override
    public List<Motorista> listarMotoristas(int opcao) {
        List<Motorista> listaMotorista = new ArrayList<>();
        connect = ConnectionFactory.getConexao();
        String sql = "";

        //opcao 1 - tras todos os motoristas
        //opcao 2 - tras motoristas com status disponivel
        if (opcao == 1) {
            sql = "SELECT mot.id, mot.nome, mot.tipo_cnh as categoria, stat.status_motorista as status, mot.numero_cnh from motorista mot\n"
                    + "JOIN status_motorista as stat ON stat.id = mot.status_motorista";
        } else if (opcao == 2) {
            sql = "SELECT mot.id, mot.nome, mot.tipo_cnh as categoria, stat.status_motorista as status, mot.numero_cnh from motorista mot\n"
                    + "JOIN status_motorista as stat ON stat.id = mot.status_motorista WHERE stat.id = 1";
        }
        PreparedStatement stat = null;
        ResultSet result = null;
        try {
            stat = connect.prepareStatement(sql);
            result = stat.executeQuery();
            Motorista motorista = null;

            if (result != null) {
                while (result.next()) {
                    motorista = new Motorista();
                    motorista.setNomeMotorista(result.getString("nome"));
                    motorista.setStatusTrabalho(StatusMotorista.valueOf(result.getString("status")));
                    motorista.setCategoriaCnh(TipoCNH.valueOf(result.getString("categoria")));
                    motorista.setNumeroCnh(Integer.toString(result.getInt("numero_cnh")));

                    listaMotorista.add(motorista);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return listaMotorista;
    }

    @Override
    public boolean verificarNumeroCNH(String numeroCNH) {

        boolean resultado = false;
        connect = ConnectionFactory.getConexao();
        String sql = "SELECT * FROM motorista WHERE numero_cnh = ?;";
        PreparedStatement stat = null;
        ResultSet result = null;
        try {
            stat = connect.prepareStatement(sql);
            stat.setString(1, numeroCNH);
            result = stat.executeQuery();

            if (result.isBeforeFirst()) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return resultado;
    }

    @Override
    public void alterarStatusMotorista(String cnh, StatusMotorista status) {
        connect = ConnectionFactory.getConexao();
        String sql = "UPDATE public.motorista\n"
                + "SET status_motorista=?\n"
                + "WHERE numero_cnh = ?;";
        PreparedStatement stat = null;
        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, status.getValorStatus());
            stat.setString(2, cnh);
            stat.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
    }

}
