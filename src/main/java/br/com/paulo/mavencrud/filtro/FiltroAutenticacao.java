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
        
        System.out.println("uri = " + uri);

        fc.doFilter(sr, sr1);
        System.out.println("do filter");
    }

    @Override
    public void destroy() {
        //
    }

}
