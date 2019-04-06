package br.paulo.mavencrud.mavencrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author paulo
 */
public class Conexao {

    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/mavencrud", "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar com o banco de dados .: " + ex.getMessage());
        }
        return null;
    }

}
