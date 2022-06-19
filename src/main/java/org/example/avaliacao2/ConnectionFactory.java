package org.example.avaliacao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {
    public static Connection conectar() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/avaliacao", "postgres", "679165");
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
