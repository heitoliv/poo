package qacademico;

import java.util.ArrayList;

public class Prova extends Avaliacao{
    private int nQuestoes;
    private ArrayList<AlunoProva> notas;

    public ArrayList<AlunoProva> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<AlunoProva> notas) {
        this.notas = notas;
    }

    public int getnQuestoes() {
        return nQuestoes;
    }

    public void setnQuestoes(int nQuestoes) {
        this.nQuestoes = nQuestoes;
    }
}
