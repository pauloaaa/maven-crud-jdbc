package br.com.paulo.mavencrud.usuario;

import java.sql.SQLException;

/**
 *
 * @author paulo
 */
public class UsuarioBO {

    protected void cadastrar(Usuario usuario) {

        UsuarioDAO usuarioDAO = null;
        try {

            usuarioDAO = new UsuarioDAO();
            if (usuario != null) {
                usuarioDAO.cadastrar(usuario);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar usuario : " + ex.getMessage());
        } finally {
            usuarioDAO = null;
        }
    }

}
