package qacademico;

import java.util.ArrayList;

public class GrupoTrabalho {
    ArrayList<Aluno> alunos;
    private double nota;

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    public void setAlunos(ArrayList<Aluno> a){
        this.alunos = a;
    }
}
