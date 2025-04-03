package banco;

public class Poupanca extends Conta{
    Poupanca(String num, Pessoa tit, Data c, Gerente g){
        super(num, tit, c, g);
    }

    double disponivel(){
        return this.saldo;
    }

    void extrato(){
        System.out.println("### EXTRATO DA CONTA ###");
        System.out.println("Número: " + this.numero);
        System.out.println("Titular: " + this.titular.nome);
        System.out.println("Valor disponível para saque: " + (this.disponivel()));
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
}
