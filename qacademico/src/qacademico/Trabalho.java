package qacademico;

import java.util.ArrayList;

public class Trabalho extends Avaliacao{
    private int nIntegrantes;
    private ArrayList<GrupoTrabalho> grupo;

    public int getnIntegrantes() {
        return nIntegrantes;
    }

    public void setnIntegrantes(int nIntegrantes) {
        this.nIntegrantes = nIntegrantes;
    }

    public ArrayList<GrupoTrabalho> getGrupo() {
        return grupo;
    }

    public void setGrupo(ArrayList<GrupoTrabalho> grupo) {
        this.grupo = grupo;
    }
}
