package qacademico;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Professor> profs;
    private ArrayList<Aluno> alunos;
    private ArrayList<Turma> turmas;

    public ArrayList<Professor> getProfs() {
        return profs;
    }

    public void setProfs(ArrayList<Professor> profs) {
        this.profs = profs;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
}
