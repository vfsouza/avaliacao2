package org.example.avaliacao2.questao9;

import org.example.avaliacao2.ConnectionFactory;
import org.example.avaliacao2.questao9.excecoes.ExistingIdException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {
    private static final Connection con = ConnectionFactory.conectar();

    public static void insert(Produto p) {
        try {
            checkId(p.getId());
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO produto (id, nome, descricao, desconto, preco, data_inicio) VALUES (" +
                    "" + p.getId() + ", '" + p.getNome() + "', '" + p.getDescricao() + "', " + p.getDesconto() + ", " +
                    "" + p.getPreco() + ", '" + p.getDataInicio() + "');");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (ExistingIdException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkId(int id) throws ExistingIdException {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM produto WHERE id = " + id);
            if(rs.next()) {
                throw new ExistingIdException();
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static Produto readById(int id) {
        Produto p = new Produto();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE id = " + id);
            rs.next();
            p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getDouble("desconto"), rs.getDouble("preco"), rs.getString("data_inicio"));
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return p;
    }

    public static ArrayList<Produto> readByString(String str) {
        ArrayList<Produto> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM produto WHERE nome LIKE '%" + str + "%'");
            while(rs.next()) {
                list.add(new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getDouble("desconto"), rs.getDouble("preco"), rs.getString("data_inicio")));
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return list;
    }

    public static void delete(int id) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM produto WHERE id = " + id);
            System.out.println("Produto deletado com sucesso");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void update(Produto p) {
        try {
            checkId(p.getId());
            System.out.println("ID nao existe no Banco de dados");
            System.out.println("Fazendo insercao");
            insert(p);
        } catch (ExistingIdException e) {
            System.out.println(e.getMessage());
            System.out.println("Update realizado com sucesso");
            try {
                Statement st = con.createStatement();
                st.executeUpdate("UPDATE produto SET nome = '" + p.getNome() + "', descricao = '" + p.getDescricao() + "', desconto = " + p.getDesconto() + ", preco = " + p.getPreco() + " WHERE id = " + p.getId());
                st.close();
            } catch (SQLException ex) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    public static ArrayList<Produto> readAll() {
        ArrayList<Produto> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM produto");
            while(rs.next()) {
                list.add(new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getDouble("desconto"), rs.getDouble("preco"), rs.getString("data_inicio")));
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return list;
    }
}
