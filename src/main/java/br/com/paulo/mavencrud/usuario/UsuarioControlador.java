package br.com.paulo.mavencrud.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo
 */
@WebServlet("/usuariocontrolador.do")
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        Usuario usuario = new Usuario();

        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.cadastrar(usuario);

    }

}
