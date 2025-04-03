package banco;

public class Banco {
    public static void main(String[] args) {
        Data dataatual = new Data(1,4,2025);
        Pessoa p1 = new Pessoa("Heitor","123.456.789-01",new Data(14,4,2005),'M');
        Pessoa p2 = new Pessoa("Junin","111.222.333-44",new Data(12,12,1994),'M');

        Gerente g = new Gerente("Giraldeli","101.101.101-01",new Data(6,7,1980),'M',"0001","12345");
        ContaCorrente c1 = new ContaCorrente("1234-5",p1,new Data(9,11,2020),g);
        ContaCorrente c2 = new ContaCorrente("2345-6",p2,new Data(9,11,2020),g);

        c1.extrato();
        c2.extrato();

        c1.sacar(150);
        c1.transferir(100,c2);
        c1.sacar(100);
        c1.depositar(100);
        c1.transferir(200,c2);

        for (int i =1; i<=365;i++){
            c1.chequeEspecial(0.5);
            System.out.println("Saldo após " + i + "dia(s) : R$" + c1.saldo);
        }
    }
}
