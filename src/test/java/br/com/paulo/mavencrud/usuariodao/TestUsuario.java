package br.com.paulo.mavencrud.usuariodao;

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
    @Test
    public void cadastrarUsuario() {

        Usuario usuario = new Usuario();

        usuario.setNome("Paulo");
        usuario.setLogin("paulo");
        usuario.setSenha("1234");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastrar(usuario);
    }
}
