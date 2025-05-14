package qacademico;

import java.util.Scanner;

public class Entrada {
    private Scanner input;

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void menu(Sistema s) {
        int opcao = lerInteiro("""
        Escolha uma opção:
        1) Cadastrar professor
        2) Cadastrar aluno
        3) Cadastrar turma
        4) Listar turmas
        0) Sair
        """);
        if (opcao == 1){
            cadProf(s);
        }
    }


    public void cadProf(Sistema s) {
        String nome = lerLinha("Digite o nome do professor:");
        String cpf = lerLinha("Digite o CPF do professor:");
        double salario = lerDouble("Digite o salário do professor:");

        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setSalario(salario);

        s.getProfs().add(professor);
    }

    public void cadAluno(Sistema s){
        String nome = lerLinha("Digite o nome do aluno:");
        String cpf = lerLinha("Digite o cpf do aluno:");
        String mat = lerLinha("Digite a matrícula do aluno:");

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setMat(mat);

        s.getAlunos().add(aluno);
    }

    public void cadTurma(Sistema s){
        String nome = lerLinha("Digite o nome da disciplina:");
        int ano = lerInteiro("Digite o ano da disciplina:");
        int sem = lerInteiro("Digite o semestre da disciplina:");
        String cpf = lerLinha("Digite o CPF do professor:");
        int quantAluno = lerInteiro("Digite a quantidade de alunos na disciplina:");
        for (int i = 0; i < quantAluno; i++) {
            Aluno aluno = new Aluno();
            String mat = lerLinha("Digite a matrícula do aluno:");
        }
        int quantAv = lerInteiro("Digite a quantidade de avaliações na disciplina:");

    }
    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    private Professor lerProf(Sistema s) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha

    }
}
