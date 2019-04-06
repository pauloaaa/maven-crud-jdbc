package br.com.paulo.mavencrud.usuariodao;

import br.com.paulo.mavencrud.usuario.Usuario;
import br.com.paulo.mavencrud.usuario.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author paulo
 */
public class TestUsuario {

    public TestUsuario() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /**
     * Método para cadastrar Usuario.
     */
//    @Test
//    public void cadastrarUsuario() {
//
//        Usuario usuario = new Usuario();
//
//        usuario.setNome("Ingrid");
//        usuario.setLogin("nega");
//        usuario.setSenha("789");
//
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        usuarioDAO.cadastrar(usuario);
//    }
    /**
     * Método para buscar usuario pelo id.
     */
//    @Test
//    public void buscarUsuario() {
//        Usuario usuario = null;
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        try {
//            usuario = usuarioDAO.buscarUsuarioPorId(1);
//            if (usuario != null) {
//                System.out.println(" usuario.toString() : " + usuario);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao buscar Usuario : " + ex.getMessage());
//        }
//    }
    /**
     * Método para excluir usuario.
     */
//    @Test
//    public void excluir() {
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        usuarioDAO.excluir(1);
//    }
    @Test
    public void listarUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            List<Usuario> usuarios = usuarioDAO.listarUsuario();

            usuarios.forEach(u -> System.out.println(u));

        } catch (SQLException ex) {
            System.out.println("Erro ao listar usuario : " + ex.getMessage());
        }
    }
}
