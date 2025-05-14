package qacademico;

public class Avaliacao {
    protected String nome;
    protected Data dtAplic;
    protected double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDtAplic() {
        return dtAplic;
    }

    public void setDtAplic(Data dtAplic) {
        this.dtAplic = dtAplic;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
