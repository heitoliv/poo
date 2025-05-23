package qacademico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior, Pedro Renã da Silva Moreira e Heitor
 */
public class Entrada {
    private Scanner input;

    /**
     * Construtor da classe Entrada
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }


    public int menu() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar professor:\n" +
                "2) Cadastrar aluno:\n" +
                "3) Cadastrar turma:\n" +
                "4) Listar turmas:\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 4) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /***************************************************/

    /**
     * Lê os dados de um novo Professor e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadProf(Sistema s) {
        s.listarProfs();

        String nome = this.lerLinha("Digite o nome do professor: ");
        String cpf = this.lerLinha("Digite o cpf do professor: ");
        double salario = this.lerDouble("Digite o salário do professor: R$");

        if (s.encontrarProf(cpf) == null) {
            Professor p = new Professor(nome, cpf, salario);
            s.novoProf(p);
            System.out.println("Professor " + p.getNome() + " adicionado com sucesso!");
        }
        else {
            System.out.println("Erro: CPF já existe. Professor não adicionado.");
        }
    }

    public void cadAluno(Sistema s) {
        s.listarAlunos();

        String nome = this.lerLinha("Digite o nome do aluno: ");
        String cpf = this.lerLinha("Digite o CPF do aluno: ");
        String matricula = this.lerLinha("Digite a matrícula do aluno: ");

        if (s.encontrarAluno(matricula) == null) {
            Aluno a = new Aluno(nome, cpf, matricula);
            s.novoAluno(a);
            System.out.println("Aluno " +  a.getNome() + " cadastrado com sucesso!");
        } else {
            System.out.println("Erro: Matrícula duplicada. Aluno não adicionado.");
        }
    }

    public void cadTurma(Sistema s) {
        s.listarTurmas();

        String disciplina = this.lerLinha("Digite o nome da disciplina: ");
        int ano = this.lerInteiro("Digite o ano da disciplina: ");
        int semestre = this.lerInteiro("Digite o semestre da disciplina: ");

        String profResponsavel = this.lerLinha("Digite o CPF do professor responsável: ");
        Professor p = s.encontrarProf(profResponsavel);
        if(p == null){
            System.out.println("Professor não cadastrado!");
            return;
        }

        int nAlunos = this.lerInteiro("Digite o número de alunos na disciplina");
        ArrayList<Aluno> alunosDisciplina = new ArrayList<>();

        for(int f = 0; f < nAlunos; f++){
            String mat = this.lerLinha("Digite a matrícula do aluno: ");
            Aluno a = s.encontrarAluno(mat);
            if(a != null){
                alunosDisciplina.add(a);
            } else {
                System.out.println("Aluno não encontrado!");
            }

        }

        int nAvaliacoes = this.lerInteiro("Digite a quantidade de avaliações da disciplina: ");
        ArrayList<Avaliacao> av = new ArrayList<>();

        for(int q = 0; q < nAvaliacoes; q++){
            System.out.println("Cadastro de avaliação: ");
            int aval = this.lerInteiro("Escolha o tipo de avaliação: \n 1)Prova \n 2)Trabalho \n Opção:  ");
            if(aval == 1){
                av.add(this.lerProva(s, alunosDisciplina));
            } else if (aval == 2){
                av.add(this.lerTrabalho(s, alunosDisciplina));
            } else {
                System.out.println("Opção inválida!");
            }
        }
        Turma t = new Turma(disciplina, ano, semestre, p, alunosDisciplina, av);
        s.novaTurma(t);
        System.out.println("Turma cadastrada com sucesso!");

    }
    /// /////////////
   /* private Professor lerProf(Sistema s) {
        ArrayList<Professor> listaProfs = s.getProfs();

        Professor prof = new Professor();
        String cpf = lerLinha("Digite o CPF do professor:");

        prof.setCpf(cpf);
        for (Professor profs : listaProfs){
            if (profs.cpf.equals(prof.cpf)){
                return prof;
            }
        }
        return null;
    }
    */

    private Professor lerProf(Sistema s) {
        String cpf = lerLinha("Digite o CPF do professor: ");
        return s.encontrarProf(cpf);
    }

    private ArrayList<Aluno> lerAlunos(Sistema s) {
        int quantAluno = lerInteiro("Digite a quantidade de alunos na disciplina: ");
        ArrayList<Aluno> alunosTurma = new ArrayList<>();

        for (int i = 0; i < quantAluno; i++) {
            String mat = lerLinha("Digite a matrícula do aluno " + (i+1) + ": ");
            Aluno aluno = s.encontrarAluno(mat);

            if (aluno != null) {
                alunosTurma.add(aluno);
            } else {
                System.out.println("Aluno com matrícula " + mat + " não encontrado!");
            }
        }

        return alunosTurma;
    }
/// //////////
    private Trabalho lerTrabalho(Sistema s, ArrayList<Aluno> alunosTurma) {
        System.out.println("\nCadastro de Trabalho:");
        String nome = lerLinha("Informe o nome desta avaliação: ");
        int dia = lerInteiro("Digite o dia do trabalho: ");
        int mes = lerInteiro("Digite o mês do trabalho: ");
        int ano = lerInteiro("Digite o ano do trabalho: ");
        double valorMaximo = lerDouble("Digite o valor máximo desta avaliação: ");
        int nIntegrantes = lerInteiro("Digite o número máximo de integrantes: ");
        int nGrupos = lerInteiro("Digite o número de grupos: ");

        ArrayList<GrupoTrabalho> grupos = new ArrayList<>();
        for (int i = 0; i < nGrupos; i++) {
            System.out.println("\nGrupo " + (i+1) + ":");
            GrupoTrabalho grupo = lerGrupoTrabalho(s);
            if (grupo != null) {
                grupos.add(grupo);
            }
        }
        return new Trabalho(nome, new Data(dia, mes, ano), valorMaximo, nIntegrantes, grupos);
    }

    private GrupoTrabalho lerGrupoTrabalho(Sistema s) {
        int numAlunos = this.lerInteiro("Digite o número de alunos neste grupo: ");
        ArrayList<Aluno> alunosGrupo = new ArrayList<>();

        for (int i = 0; i < numAlunos; i++) {
            String mat = lerLinha("Digite a matrícula do aluno " + (i + 1) + ": ");
            Aluno alunoEncontrado = s.encontrarAluno(mat);

            if (alunoEncontrado != null) {
                alunosGrupo.add(alunoEncontrado);
            } else {
                System.out.println("Aluno com matrícula " + mat + " não encontrado!");
            }
        }

        if (alunosGrupo.size() == 0) {
            return null;
        }

        double nota = lerDouble("Nota do grupo: ");
        return new GrupoTrabalho(alunosGrupo, nota);
    }
    private Prova lerProva(Sistema s, ArrayList<Aluno> alunosTurma) {
        System.out.println("\nCadastro de Prova:");
        String nome = lerLinha("Informe o nome desta prova: ");
        int dia = lerInteiro("Digite o dia da prova: ");
        int mes = lerInteiro("Digite o mês da prova: ");
        int ano = lerInteiro("Digite o ano da prova: ");
        double valorMaximo = lerDouble("Digite o valor máximo desta avaliação: ");
        int nQuestoes = lerInteiro("Digite o número de questões: ");

        ArrayList<AlunoProva> alunosProvas = new ArrayList<>();
        for (Aluno aluno : alunosTurma) {
            alunosProvas.add(lerAlunoProva(aluno, nQuestoes));
        }

        return new Prova(nome, new Data(dia, mes, ano), valorMaximo, nQuestoes, alunosProvas);
    }

    private AlunoProva lerAlunoProva(Aluno aluno, int nQuestoes) {
        double[] notas = new double[nQuestoes];
        for (int i = 0; i < nQuestoes; i++) {
            notas[i] = lerDouble("Nota de " + aluno.getNome() + " na questão " + (i+1) + ": ");
        }
        return new AlunoProva(aluno, notas);
    }

    /// /DEU ERRADO
   /* public void cadTurma(Sistema s){
        Turma turma = new Turma();

        String nome = lerLinha("Digite o nome da disciplina:");
        int ano = lerInteiro("Digite o ano da disciplina:");
        int sem = lerInteiro("Digite o semestre da disciplina:");


        Professor prof = lerProf(s);
        ArrayList<Aluno> alunosTurma = lerAlunos(s);

        turma.setNome(nome);
        turma.setAno(ano);
        turma.setSem(sem);
        turma.setProf(prof);
        turma.setAlunos(alunosTurma);

        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        int quantAv = lerInteiro("Digite a quantidade de avaliações na disciplina:");

        Prova provas = new Prova();
        ArrayList<AlunoProva> totalProva = new ArrayList<>();
        ArrayList<Double> notasProva = new ArrayList<>();
        AlunoProva alunoprova = new AlunoProva();
        for (int i = 1; i <= quantAv; i++) {
            int opcao = lerInteiro("""
            Escolha uma opção:
            1) Prova
            2) Trabalho
            """);
            if (opcao == 1){
                String nomeProva = lerLinha("Informe o nome desta avaliação:");
                int diaProva = lerInteiro("Digite o dia da prova:");
                int mesProva = lerInteiro("Digite o mês da prova:");
                int anoProva = lerInteiro("Digite o ano da prova:");
                double valorProva = lerDouble("Digite o valor máximo desta avaliação:");
                int numQuestoes = lerInteiro("Digite o número de questões:");

                provas.setnQuestoes(numQuestoes);
                for (Aluno alTurma : alunosTurma){
                    double nota = 0;
                    for (int j = 1; j <= numQuestoes; j++){
                        alunoprova.setAluno(alTurma);
                        nota = lerDouble("Nota de " + alTurma.getNome() + "na questão " + j);
                        nota++;
                        notasProva.add(nota);
                        alunoprova.setNotas(notasProva);
                    }
                    totalProva.add(alunoprova);
                }
            } else if (opcao == 2){
                Trabalho trabalho = lerTrabalho(s, alunosTurma);
                if (trabalho != null) {
                    avaliacoes.add(trabalho);
                }
            }
        }

        turma.setAvs(avaliacoes);
        s.getTurmas().add(turma);
    }
*/

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

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
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
}
