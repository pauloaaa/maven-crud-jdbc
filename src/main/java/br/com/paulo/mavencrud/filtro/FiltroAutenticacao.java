package br.com.paulo.mavencrud.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo
 */
public class FiltroAutenticacao implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;

        String uri = request.getRequestURL().toString();

        HttpSession sessao = request.getSession(false);

        if (sessao != null || uri.contains("login.html") || uri.contains("autenticadorcontrolador.do")) {
            fc.doFilter(sr, sr1);
        } else {
            response.sendRedirect("login.html");
        }

    }

    @Override
    public void destroy() {
        //
    }

}
