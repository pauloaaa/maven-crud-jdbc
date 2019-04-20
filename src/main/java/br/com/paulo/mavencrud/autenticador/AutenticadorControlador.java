package br.com.paulo.mavencrud.autenticador;

import br.com.paulo.mavencrud.usuario.Usuario;
import br.com.paulo.mavencrud.usuario.UsuarioBO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo
 */
@WebServlet("/autenticadorcontrolador.do")
public class AutenticadorControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sessao = req.getSession(false);
        if (sessao != null) {
            sessao.invalidate();
        }
        req.getRequestDispatcher("login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);

        UsuarioBO bo = new UsuarioBO();
        Usuario usuarioAutenticado = bo.autenticar(usuario);

        if (usuarioAutenticado != null) {
            HttpSession sessao = req.getSession();

            sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);

            sessao.setMaxInactiveInterval(60 * 5);

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            resp.getWriter().print("<script>window.alert('não encontrado!'); location.href='login.html'</script>");
        }

    }

}
