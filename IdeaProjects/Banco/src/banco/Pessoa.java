package banco;

public class Pessoa {
    String nome;
    String cpf;
    Data data_nasc;
    char sexo;

    Pessoa(){
        this.data_nasc = new Data();
        System.out.println("Nova pessoa cadastrada no sistema");
    }

    Pessoa(String n, String c, int d, int m, int a, char s){
        this.nome = n;
        this.cpf = c;
        this.data_nasc = new Data(d,m,a);
        this.sexo = s;
        Data dataatual = new Data(1,4,2025);
        calculaIdade(dataatual);
        System.out.println("Nova pessoa cadastrada no sistema");
    }

    int calculaIdade(Data data){
         if (data.dia < this.data_nasc.dia && data.mes < this.data_nasc.mes){
             return ((data.ano - data_nasc.ano) - 1);
         }
         else{
             return data.ano - data_nasc.ano;
         }
    }
}
