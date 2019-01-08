package dao.bd;

import dao.ConnectionFactory;
import dao.VeiculoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Veiculo;
import util.StatusVeiculo;
import util.TipoVeiculo;

public class VeiculoBancoDAO implements VeiculoDao {

    private static Connection connect;

    @Override
    public void salvarVeiculo(Veiculo veiculo) {
        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        String sql = "INSERT INTO veiculo (placa, marca, ano, tipo_veiculo , status_veiculo) VALUES (?,?,?,?,?)";

        try {
            stat = connect.prepareStatement(sql);
            int a = veiculo.getTipoVeiculo().getId();
            stat.setString(1, veiculo.getPlacaVeiculo());
            stat.setString(2, veiculo.getMarcaVeiculo());
            stat.setString(3, veiculo.getAnoVeiculo());
            stat.setInt(4, veiculo.getTipoVeiculo().getId());
            stat.setInt(5, StatusVeiculo.LIVRE.getValorStatus());
            stat.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar veículo");
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
    }

    @Override
    public List<Veiculo> listarVeiculos(int opcao) {
        List<Veiculo> listaDeVeiculos = new ArrayList<>();
        connect = ConnectionFactory.getConexao();
        String sql = "";

        //opcao 1 - retorna todos os veiculos
        // opcao 2 - retorna somente veiculos com status disponivel
        if (opcao == 1) {
            sql = "SELECT vel.placa, tv.descricao as tipo_veiculo, tv.capacidade, vel.marca, vel.ano, sv.status_veiculo\n"
                    + "FROM veiculo vel\n"
                    + "JOIN tipo_veiculo tv ON tv.id = vel.tipo_veiculo\n"
                    + "JOIN status_veiculo sv ON sv.id = vel.status_veiculo";
        } else if (opcao == 2) {
            sql = "SELECT vel.placa, tv.descricao as tipo_veiculo, tv.capacidade, vel.marca, vel.ano, sv.status_veiculo\n"
                    + "FROM veiculo vel\n"
                    + "JOIN tipo_veiculo tv ON tv.id = vel.tipo_veiculo\n"
                    + "JOIN status_veiculo sv ON sv.id = vel.status_veiculo\n"
                    + "WHERE vel.status_veiculo = 1";
        }
        PreparedStatement stat = null;
        ResultSet result = null;
        try {
            stat = connect.prepareStatement(sql);
            result = stat.executeQuery();
            Veiculo veiculo;

            if (result != null) {
                while (result.next()) {
                    veiculo = new Veiculo();
                    veiculo.setPlacaVeiculo(result.getString("placa"));
                    veiculo.setTipoVeiculo(TipoVeiculo.valueOf(result.getString("tipo_veiculo")));
                    veiculo.setCapacidadeCarga(result.getInt("capacidade"));
                    veiculo.setMarcaVeiculo(result.getString("marca"));
                    veiculo.setAnoVeiculo(result.getString("ano"));
                    veiculo.setTipoVeiculo(TipoVeiculo.valueOf(result.getString("tipo_veiculo")));
                    veiculo.setStatusVeiculo(StatusVeiculo.valueOf(result.getString("status_veiculo")));

                    listaDeVeiculos.add(veiculo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro");
        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return listaDeVeiculos;
    }

    @Override
    public int buscarIdVeiculo(String placa) {
        int idVeiculo = 0;
        connect = ConnectionFactory.getConexao();
        String sql = "SELECT id FROM veiculo WHERE veiculo.placa = ?";
        PreparedStatement stat = null;
        ResultSet result = null;
        try {
            stat = connect.prepareStatement(sql);
            stat.setString(1, placa);
            result = stat.executeQuery();

            if (result != null) {
                while (result.next()) {
                    idVeiculo = result.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro");
        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return idVeiculo;
    }

    @Override
    public void alterarStatusVeiculo(String placa, StatusVeiculo status) {
        connect = ConnectionFactory.getConexao();
        String sql = "UPDATE veiculo\n"
                + "SET status_veiculo = ?\n"
                + "WHERE placa = ?;";
        PreparedStatement stat = null;
        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, status.getValorStatus());
            stat.setString(2, placa);
            stat.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
    }

}
