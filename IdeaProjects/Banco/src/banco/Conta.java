package banco;

public class Conta {
    String numero;
    Pessoa titular;
    double saldo;
    double limite;

    double disponivel(){
        return this.saldo + this.limite;
    }

    void extrato(){
        System.out.println("### EXTRATO DA CONTA ###");
        System.out.println("Número: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.println("Valor disponível para saque: " + (this.disponivel()));
    }

    void depositar(double valor){
        this.saldo = this.saldo + valor;
        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Novo saldo: R$" + this.saldo);
    }

    boolean sacar(double valor){
        if (valor <= this.disponivel()){
            this.saldo = this.saldo - valor;
            System.out.println("Saque na conta " + this.numero + " realizado com sucesso. Novo saldo: R$" + this.saldo);
            return true;
        }
        else{
            System.out.println("ERRO: Saque na conta " + this.numero + " não foi realizado com sucesso. Valor disponível " + this.disponivel());
            return false;
        }
    }

    boolean transferir(double valor, Conta destino){
        if (this.sacar(valor)){
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " da conta " + this.numero + " para a conta " + destino.numero + " realizado com sucesso!");
            return true;
        }
        else{
            System.out.println("Não foi possível realizar transferência de R$" + valor + " da conta " + this.numero + " para a conta " + destino.numero);
            return false;
        }
    }

    void chequeEspecial(double juros){
    if(this.saldo < 0){
        this.saldo = this.saldo + (juros * this.saldo)/100;
    }
    }

    Conta(String num, Pessoa tit, double s, double lim){
        this.numero = num;
        this.titular = tit;
        this.saldo = s;
        this.limite = lim;
        System.out.println("Conta " + this.numero + " pertence ao titular: " + this.titular.nome);
    }
}
