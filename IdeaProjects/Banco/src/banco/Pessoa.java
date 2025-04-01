package banco;

public class Pessoa {
    String nome;
    String cpf;
    Data data_nasc;
    char sexo;

    Pessoa(){
        System.out.println("Nova pessoa cadastrada no sistema");
    }

    Pessoa(String n, String c, Data i, char s){
        this.nome = n;
        this.cpf = c;
        this.data_nasc = i;
        this.sexo = s;
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
