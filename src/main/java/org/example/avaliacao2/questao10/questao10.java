package org.example.avaliacao2.questao10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class questao10 {
    public static void main(String[] args) {
        String op;
        System.out.println("Digite 0 para sair");
        while(true) {
            Mensagem msg = new Mensagem();
            Scanner sc = new Scanner(System.in);
            int happy = 0;
            int sad = 0;
            try {
                System.out.println("\nDigite uma frase:");
                String str = sc.nextLine();

                if (str.replaceAll(" ", "").equals("0")) {
                    break;
                }

                msg.setMsg(str);
                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == ':' && str.charAt(i + 1) == '-' && str.charAt(i + 2) == ')') {
                        happy++;
                    }
                    if(str.charAt(i) == ':' && str.charAt(i + 1) == '-' && str.charAt(i + 2) == '(') {
                        sad++;
                    }
                }
                if (happy > sad) {
                    msg.setEmocao("divertido");
                } else if (sad > happy) {
                    msg.setEmocao("chateado");
                } else {
                    msg.setEmocao("neutro");
                }

                MensagemDAO.insert(msg);
                System.out.println("Saida: " + msg.getEmocao());
            } catch (InputMismatchException e) {
                System.out.println("So sao aceitos numeros");
            }
        }
    }
}
