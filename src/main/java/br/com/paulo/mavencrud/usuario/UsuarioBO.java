package br.com.paulo.mavencrud.usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    protected List<Usuario> listarUsuario() {
        UsuarioDAO usuarioDAO = null;
        try {
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO.listarUsuario();
        } catch (SQLException ex) {
            System.out.println("Erro listar Usuario .: " + ex.getMessage());
        } finally {
            usuarioDAO = null;
        }
        return null;

    }
    
    public Usuario autenticar(Usuario usuario){
        UsuarioDAO usuarioDAO = null;
        
        try {
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO.autenticar(usuario);
        } catch (SQLException ex) {
            System.out.println("Erro Autenticar Usuario .: " + ex.getMessage());
        } finally {
            usuarioDAO = null;
        }
        return null;
    }

}
