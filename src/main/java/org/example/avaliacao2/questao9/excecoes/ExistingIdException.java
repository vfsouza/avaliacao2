package org.example.avaliacao2.questao9.excecoes;

public class ExistingIdException extends Exception {

    public ExistingIdException() {
        super("O ID existe no Banco de Dados");
    }

    public ExistingIdException(String msg) {
        super(msg);
    }
}
