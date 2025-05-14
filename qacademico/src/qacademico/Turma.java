package qacademico;

import java.util.ArrayList;

public class Turma {
    private String nome;
    private int ano;
    private int sem;
    private Professor prof;
    private ArrayList<Aluno> alunos;
    private ArrayList<Avaliacao> avs;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Avaliacao> getAvs() {
        return avs;
    }

    public void setAvs(ArrayList<Avaliacao> avs) {
        this.avs = avs;
    }
}
