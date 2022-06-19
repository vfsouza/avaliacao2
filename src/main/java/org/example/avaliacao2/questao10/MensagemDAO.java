package org.example.avaliacao2.questao10;

import org.example.avaliacao2.ConnectionFactory;
import org.example.avaliacao2.questao9.Produto;
import org.example.avaliacao2.questao9.excecoes.ExistingIdException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MensagemDAO {
    private static final Connection con = ConnectionFactory.conectar();

    public static void insert(Mensagem m) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO mensagem (mensagem, emocao) VALUES ('" + m.getMsg() + "', '" + m.getEmocao() + "');");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
