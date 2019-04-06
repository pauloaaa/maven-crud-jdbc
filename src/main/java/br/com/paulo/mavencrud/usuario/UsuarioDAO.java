package br.com.paulo.mavencrud.usuario;

import br.paulo.mavencrud.mavencrud.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class UsuarioDAO {

    private final Connection con = Conexao.getConnection();

    public void excluir(int id) {
        int index = 0;
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement prepSt = con.prepareStatement(sql)) {

            prepSt.setInt(++index, id);

            prepSt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir usuario : " + ex.getMessage());
        } finally {
            sql = null;
        }
    }

    public void cadastrar(Usuario usuario) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USUARIO (nome, login, senha) VALUES (?,?,?)");
        try {
            PreparedStatement prepSt = con.prepareStatement(sql.toString());
            prepSt.setString(1, usuario.getNome());
            prepSt.setString(2, usuario.getLogin());
            prepSt.setString(3, usuario.getSenha());
            prepSt.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            sql.delete(0, sql.length());
            sql = null;
        }
    }

    public Usuario buscarUsuarioPorId(int idUsuario) throws SQLException {
        Usuario usuario = null;
        PreparedStatement prepSt = null;
        String sql = "SELECT id, nome, login, senha FROM usuario WHERE id = ?";
        int index = 0;
        ResultSet rs = null;
        try {
            prepSt = con.prepareStatement(sql);

            prepSt.setInt(++index, idUsuario);

            rs = prepSt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nome"));

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Usuario : " + ex.getMessage());
        } finally {
            if (prepSt != null && prepSt.isClosed()) {
                prepSt.close();
                prepSt = null;
            }
            if (rs != null && rs.isClosed()) {
                rs.close();
                rs = null;
            }
            sql = null;
        }
        return usuario;

    }

    public List<Usuario> listarUsuario() throws SQLException {
        Usuario usuario = null;
        PreparedStatement prepSt = null;
        String sql = "SELECT id, nome, login, senha FROM usuario ";
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            prepSt = con.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nome"));

                usuarios.add(usuario);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Usuario : " + ex.getMessage());
        } finally {
            if (prepSt != null && prepSt.isClosed()) {
                prepSt.close();
                prepSt = null;
            }
            if (rs != null && rs.isClosed()) {
                rs.close();
                rs = null;
            }
            sql = null;
        }
        return usuarios;

    }

}
