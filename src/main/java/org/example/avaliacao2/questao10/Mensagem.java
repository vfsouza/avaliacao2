package org.example.avaliacao2.questao10;

public class Mensagem {
    private int id;
    private String msg;
    private String emocao;

    public Mensagem() { }

    public Mensagem(int id, String msg, String emocao) {
        this.id = id;
        this.msg = msg;
        this.emocao = emocao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEmocao() {
        return emocao;
    }

    public void setEmocao(String emocao) {
        this.emocao = emocao;
    }
}
