package dao.bd;

import dao.ConnectionFactory;
import dao.EncomendaDAO;
import model.Encomenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import util.StatusEncomenda;

public class EncomendaBancoDAO implements EncomendaDAO {

    private static Connection connect = null;

    @Override
    public List<Endereco> verificarEndereco(int numeroDes, String ruaDes) {
        List<Endereco> listaEndereco = new ArrayList<>();
        connect = ConnectionFactory.getConexao();
        String sql = "SELECT * FROM endereco WHERE numero = '" + numeroDes + "' AND rua = '" + ruaDes + "'";
        PreparedStatement stat = null;
        ResultSet result = null;
        try {
            stat = connect.prepareStatement(sql);
            result = stat.executeQuery();
            Endereco listEncomenda = null;

            if (result != null) {
                while (result.next()) {
                    listEncomenda = new Endereco();
                    listEncomenda.setNumero(result.getInt("numero"));
                    listEncomenda.setRua(result.getString("rua"));

                    listaEndereco.add(listEncomenda);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro");
        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return listaEndereco;
    }

    @Override
    public int buscarIdEndereco(int numero, String rua) {
        int idEndereco = 0;
        connect = ConnectionFactory.getConexao();
        String sql = "SELECT id FROM endereco WHERE numero = ? AND rua = ?";
        PreparedStatement stat = null;
        ResultSet result = null;
        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, numero);
            stat.setString(2, rua);
            result = stat.executeQuery();
            while (result.next()) {
                idEndereco = result.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Erro");
        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return idEndereco;
    }

    @Override
    public boolean adicionarEndereco(String estado, String cidade, String rua, int numero, String complemento, String cep) {
        boolean resultSalvar = false;
        PreparedStatement stat = null;

        try {
            connect = ConnectionFactory.getConexao();
            String sql = "INSERT INTO endereco (cep, estado, cidade, rua , numero, complemento ) VALUES (?,?,?,?,?,?);";

            stat = connect.prepareStatement(sql);
            stat.setString(1, cep);
            stat.setString(2, estado);
            stat.setString(3, cidade);
            stat.setString(4, rua);
            stat.setInt(5, numero);
            stat.setString(6, complemento);
            stat.executeUpdate();

            resultSalvar = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
        return resultSalvar;
    }

    @Override
    public boolean verificarCodigoEncomenda(int codigoCaixa) {
        boolean resultado = false;
        connect = ConnectionFactory.getConexao();
        String sql = "SELECT * FROM encomenda WHERE codigo_encomenda = '" + codigoCaixa + "'";
        PreparedStatement stat = null;
        ResultSet result = null;
        try {
            stat = connect.prepareStatement(sql);
            //stat.setInt(1, codigoCaixa);
            result = stat.executeQuery();

            if (result.isBeforeFirst()) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro");
        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return resultado;
    }

    @Override
    public boolean adicionarEncomenda(Encomenda encomenda) {
        boolean resultSalvar = false;
        PreparedStatement stat = null;
        adicionarEndereco(encomenda.getEnderecoRemetente().getEstado(), encomenda.getEnderecoRemetente().getCidade(), encomenda.getEnderecoRemetente().getRua(), encomenda.getEnderecoRemetente().getNumero(), encomenda.getEnderecoRemetente().getComplemento(), encomenda.getEnderecoRemetente().getCep());
        adicionarEndereco(encomenda.getEnderecoDestinatario().getEstado(), encomenda.getEnderecoDestinatario().getCidade(), encomenda.getEnderecoDestinatario().getRua(), encomenda.getEnderecoDestinatario().getNumero(), encomenda.getEnderecoDestinatario().getComplemento(), encomenda.getEnderecoDestinatario().getCep());

        int idEnderecoDestinatario = buscarIdEndereco(encomenda.getEnderecoDestinatario().getNumero(), encomenda.getEnderecoDestinatario().getRua());
        int idEnderecoRemetente = buscarIdEndereco(encomenda.getEnderecoRemetente().getNumero(), encomenda.getEnderecoRemetente().getRua());
        try {
            connect = ConnectionFactory.getConexao();
            String sql = "INSERT INTO encomenda (codigo_encomenda, data_postagem, peso, nome_remetente , endereco_remetente, endereco_destinatario, status_encomenda, nome_destinatario) VALUES (?,?,?,?,?,?,?,?);";

            stat = connect.prepareStatement(sql);
            stat.setInt(1, encomenda.getCodigoEncomenda());
            stat.setString(2, encomenda.getDataPostagem());
            stat.setDouble(3, encomenda.getPeso());
            stat.setString(4, encomenda.getNomeRemetente());
            stat.setInt(5, idEnderecoRemetente);
            stat.setInt(6, idEnderecoDestinatario);
            stat.setInt(7, encomenda.getStatusEncomenda().getValorStatus());
            stat.setString(8, encomenda.getNomeDestinatario());
            stat.executeUpdate();

            resultSalvar = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
        return resultSalvar;
    }

    @Override
    public List<Encomenda> retornarEncomendas() {
        List<Encomenda> listaEncomendas = new ArrayList<>();
        PreparedStatement stat = null;
        try {
            connect = ConnectionFactory.getConexao();
            String sql = "SELECT codigo_encomenda as codigo, peso, data_postagem, se.status_encomenda FROM encomenda as enc\n"
                    + "JOIN status_encomenda se ON se.id = enc.status_encomenda\n"
                    + "WHERE enc.status_encomenda = 1 OR enc.status_encomenda = 2 OR enc.status_encomenda = 3\n"
                    + "ORDER BY enc.id ASC";
            
            stat = connect.prepareStatement(sql);
            ResultSet result = stat.executeQuery();

            if (result != null) {
                while (result.next()) {
                    Encomenda encomenda = new Encomenda();
                    encomenda.setCodigoEncomenda(result.getInt("codigo"));
                    encomenda.setPeso(result.getDouble("peso"));
                    encomenda.setDataPostagem(result.getString("data_postagem"));
                    encomenda.setStatusEncomenda(StatusEncomenda.valueOf(result.getString("status_encomenda")));
                    listaEncomendas.add(encomenda);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }

        return listaEncomendas;
    }

    @Override
    public void alterarStatusEncomenda(int codigoEncomenda, StatusEncomenda status) {
        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        String sql = "UPDATE encomenda\n"
                + "SET status_encomenda = ?\n"
                + "WHERE codigo_encomenda = ?";
        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, status.getValorStatus());
            stat.setInt(2, codigoEncomenda);
            stat.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
    }

    @Override
    public void alterarStatusEncomendaPendente() {

        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        String sql = "UPDATE encomenda\n"
                + "SET status_encomenda = ?\n"
                + "WHERE status_encomenda = ?";
        try {
            stat = connect.prepareStatement(sql);
            stat.setInt(1, 2);
            stat.setInt(2, 3);
            stat.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
    }
}
