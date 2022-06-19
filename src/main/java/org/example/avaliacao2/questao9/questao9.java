package org.example.avaliacao2.questao9;

import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class questao9 {
    public static void main(String[] args) {
        //ProdutoDAO.insert();
        int op;

        do {
            op = -1;
            ArrayList<Produto> list = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            System.out.println("\n======== Sistema ========");
            System.out.println("1 - INSERIR oferta");
            System.out.println("2 - ATUALIZAR oferta");
            System.out.println("3 - DELETAR oferta");
            System.out.println("4 - LER por palavra chave");
            System.out.println("5 - LER oferta");
            System.out.println("6 - LER TODAS as ofertas");
            System.out.println("0 - Sair");
            System.out.print(": ");
            try {
                int id = 0;
                String nome = "", descricao = "";
                double desconto = 0F, preco = 0F;
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        System.out.println("\n\nINSERIDO PRODUTO\n");
                        System.out.print("ID do produto: ");
                        id = sc.nextInt();
                        System.out.print("Nome do produto: ");
                        sc = new Scanner(System.in);
                        nome = sc.nextLine();
                        System.out.print("Descricao do produto: ");
                        descricao = sc.nextLine();
                        System.out.print("Desconto do produto: ");
                        desconto = sc.nextDouble();
                        System.out.print("Preco do produto: ");
                        preco = sc.nextDouble();
                        ProdutoDAO.insert(new Produto(id, nome, descricao, desconto, preco));
                        break;

                    case 2:
                        System.out.println("\n\nATUALIZANDO PRODUTO\n");
                        System.out.print("ID do produto: ");
                        id = sc.nextInt();
                        System.out.print("Nome do produto: ");
                        sc = new Scanner(System.in);
                        nome = sc.nextLine();
                        System.out.print("Descricao do produto: ");
                        descricao = sc.nextLine();
                        System.out.print("Desconto do produto: ");
                        desconto = sc.nextDouble();
                        System.out.print("Preco do produto: ");
                        preco = sc.nextDouble();
                        ProdutoDAO.update(new Produto(id, nome, descricao, desconto, preco));
                        break;

                    case 3:
                        System.out.println("\n\nDELETANDO PRODUTO\n");
                        System.out.print("ID do produto: ");
                        id = sc.nextInt();
                        ProdutoDAO.delete(id);
                        break;

                    case 4:
                        System.out.println("\n\nLENDO POR PALAVRA CHAVE");
                        System.out.print("Palavra: ");
                        sc = new Scanner(System.in);
                        String str = sc.nextLine();
                        list = ProdutoDAO.readByString(str);
                        for (Produto produto : list) {
                            System.out.println(produto.toString());
                        }
                        break;

                    case 5:
                        System.out.println("\n\nLER OFERTA\n");
                        System.out.print("ID da oferta: ");
                        id = sc.nextInt();
                        Produto p = ProdutoDAO.readById(id);
                        System.out.println(p.toString());
                        break;

                    case 6:
                        System.out.println("\n\nLENDO TODAS AS OFERTAS\n");
                        list = ProdutoDAO.readAll();
                        for (Produto produto : list) {
                            System.out.println(produto.toString());
                        }
                        break;

                    default:

                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("So sao aceitos numeros");
            }
        } while (op != 0);
    }
}
