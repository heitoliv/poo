package banco;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo;
    double limite;

    void extrato(){
        System.out.println("### EXTRATO DA CONTA ###");
        System.out.println("Número: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.println("Valor disponível para saque: " + (this.saldo + this.limite));
    }
}
