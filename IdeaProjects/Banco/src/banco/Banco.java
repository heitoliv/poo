package banco;

public class Banco {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.nome = "Heitor";
        p1.cpf = "123.456.789-01";
        p1.idade = 19;
        p1.sexo = 'M';

        Pessoa p2 = new Pessoa();
        p2.nome = "Junin";
        p2.cpf = "111.222.333-44";
        p2.idade = 21;
        p2.sexo = 'M';

        Conta c1 = new Conta();
        c1.numero = "1234-5";
        c1.titular = p1;
        c1.saldo = 0;
        c1.limite = 200;

        Conta c2 = new Conta();
        c2.numero = "2345-6";
        c2.titular = p2;
        c2.saldo = 100000;
        c2.limite = 200;

        c1.extrato();
        c2.extrato();

        c1.sacar(150);
        c1.transferir(100,c2);
        c1.sacar(100);
        c1.depositar(100);
        c1.transferir(200,c2);
        c1.cheque_especial(0.1);
        c2.cheque_especial(0.2);
    }
}
