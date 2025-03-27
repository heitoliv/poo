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

    double cheque_especial(double juros){
        if (this.saldo < 0){
            System.out.println("O saldo antigo da conta " + this.numero + " é de " + this.saldo);
            this.saldo = this.saldo + (this.saldo * juros);
            System.out.println("O saldo da conta " + this.numero + " obteve juros e está atualizado para " + this.saldo);
            return this.saldo;
        }
        else{
            System.out.println("O saldo da conta " + this.numero + " está positivo, não obteve juros.");
            return this.saldo;
        }
    }
}
