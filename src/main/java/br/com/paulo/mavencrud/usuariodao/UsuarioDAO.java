package br.com.paulo.mavencrud.usuariodao;

import br.paulo.mavencrud.mavencrud.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author paulo
 */
class UsuarioDAO {

    private final Connection con = Conexao.getConnection();

    public void cadastrar(Usuario usuario) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USUARIO (nome, login, senha) VALUES (?,?,?)");
        try {
            PreparedStatement prepSt = con.prepareStatement(sql.toString());
            prepSt.setString(1, usuario.getNome());
            prepSt.setString(2, usuario.getLogin());
            prepSt.setString(3, usuario.getSenha());
            prepSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar no banco de dados .: " + e.getMessage());
        } finally {
            sql.delete(0, sql.length());
            sql = null;
        }
    }

}
