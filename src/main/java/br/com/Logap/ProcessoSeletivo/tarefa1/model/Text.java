package br.com.Logap.ProcessoSeletivo.tarefa1.model;

public class Text {

    private String string;
    private char vogal;
    private String tempoTotal;

    public Text(String string, char vogal, String tempototal) {
        this.string = string;
        this.vogal = vogal;
        this.tempoTotal = tempototal;
    }

    public String getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(String tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public char getVogal() {
        return vogal;
    }

    public void setVogal(char vogal) {
        this.vogal = vogal;
    }
}
