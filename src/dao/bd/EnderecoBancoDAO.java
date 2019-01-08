package dao.bd;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Endereco;

public class EnderecoBancoDAO {

    private static Connection connect;

    public static int buscarIdEndereco(int numero, String rua) {
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

    public static boolean adicionarEndereco(Endereco endereco) {
        boolean resultSalvar = false;
        PreparedStatement stat = null;
        try {
            connect = ConnectionFactory.getConexao();
            String sql = "INSERT INTO endereco (cep, estado, cidade, rua , numero, complemento ) VALUES (?,?,?,?,?,?);";

            stat = connect.prepareStatement(sql);
            stat.setString(1, endereco.getCep());
            stat.setString(2, endereco.getEstado());
            stat.setString(3, endereco.getCidade());
            stat.setString(4, endereco.getRua());
            stat.setInt(5, endereco.getNumero());
            stat.setString(6, endereco.getComplemento());
            stat.executeUpdate();

            resultSalvar = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }
        return resultSalvar;
    }

}
