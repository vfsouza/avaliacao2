package org.example.avaliacao2.questao9;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double desconto;
    private double preco;
    private String dataInicio = "" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getYear();

    public Produto() { }

    public Produto(int id, String nome, String descricao, double desconto, double preco, String dataInicio) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
        this.preco = preco;
        this.dataInicio = dataInicio;
    }

    public Produto(String nome, String descricao, double desconto, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
        this.preco = preco;
        this.dataInicio = "" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getYear();
    }

    public Produto(int id, String nome, String descricao, double desconto, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
        this.preco = preco;
        this.dataInicio = "" + LocalDateTime.now().getDayOfMonth() + "/" + LocalDateTime.now().getMonthValue() + "/" + LocalDateTime.now().getYear();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "\nProduto #" + id + "\n" +
                "Nome : " + nome + "\n" +
                "Descricao: " + descricao + "\n" +
                "Desconto: " + desconto + "%\n" +
                "Preco: R$ " + preco + "\n" +
                "Data de inicio: " + dataInicio.toString();
    }
}
