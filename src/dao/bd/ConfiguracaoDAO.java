package dao.bd;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfiguracaoDAO {

    private Connection connect;

    public void gravarUltimoDiaUsoSistema(Date ultimoUso) {

        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;

        String sql = "UPDATE configuracao \n"
                + "SET ultimo_dia_uso_sistema = ? \n"
                + "WHERE id = 1";
        try {
            stat = connect.prepareStatement(sql);
            stat.setDate(1, (java.sql.Date) ultimoUso);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.err.print(e);

        } finally {
            ConnectionFactory.fecharConexao(connect, stat);
        }

    }

    public Date retornaUltimoDiaUsoSistema() {

        Date ultimoUso = null;
        connect = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet result = null;
        String sql = "SELECT ultimo_dia_uso_sistema as data\n"
                + "FROM configuracao \n"
                + "WHERE id = 1";
        try {
            stat = connect.prepareStatement(sql);
            result = stat.executeQuery();
            while (result.next()) {
                ultimoUso = result.getDate("data");
            }
        } catch (SQLException e) {
            System.err.print(e);

        } finally {
            ConnectionFactory.fecharConexao(connect, stat, result);
        }
        return ultimoUso;
    }

}
