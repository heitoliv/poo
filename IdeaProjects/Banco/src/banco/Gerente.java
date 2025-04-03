package banco;

public class Gerente extends Pessoa {
    String mat;
    String senha;

    Gerente(String nome, String cpf, Data d, char s, String mat, String senha){
        super(nome, cpf, d, s);
        this.mat = mat;
        this.senha = senha;
    }

    boolean validarAcesso(String senha){
        return senha.equals(this.senha);
    }
}
