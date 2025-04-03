package banco;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo;
    Data criacao;
    Gerente gerente;



    Conta(String num, Pessoa tit, Data c, Gerente g){
        this.numero = num;
        this.titular = tit;
        this.criacao = c;
        this.gerente = g;
        this.saldo = 0;
        System.out.println("Conta " + this.numero + " pertence ao titular: " + this.titular.nome);
    }

    void depositar(double valor){
        this.saldo = this.saldo + valor;
        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Novo saldo: R$" + this.saldo);
    }
}
