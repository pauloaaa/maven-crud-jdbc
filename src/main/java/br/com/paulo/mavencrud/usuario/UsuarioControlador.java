package br.com.paulo.mavencrud.usuario;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
        
        resp.sendRedirect("usuariocontrolador.do?acao=listar");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        UsuarioBO bo = null;
        RequestDispatcher dispatcher = null;
        List<Usuario> usuarios = null;
        String acao = "";
        try {

            acao = req.getParameter("acao");

            if (acao.equals("listar")) {

                bo = new UsuarioBO();
                usuarios = bo.listarUsuario();

                req.setAttribute("usuarios", usuarios);

                dispatcher = req.getRequestDispatcher("/listar_usuario.jsp");
                dispatcher.forward(req, resp);

            } else if (acao.equals("novoCadastro")) {

                dispatcher = req.getRequestDispatcher("/cadastrar_usuario.html");
                dispatcher.forward(req, resp);

            }
        } finally {
            bo = null;
            dispatcher = null;
            usuarios = null;
            acao = null;
        }

    }

}
