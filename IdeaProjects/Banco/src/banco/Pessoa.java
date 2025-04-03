package banco;

public class Pessoa {
    String nome;
    String cpf;
    Data data_nasc;
    char sexo;

    Pessoa(String nome, String cpf, Data d, char s){
        System.out.println("Nova pessoa cadastrada no sistema");
        this.nome = nome;
        this.cpf = cpf;
        this.data_nasc = d;
        this.sexo = s;
    }

    int calculaIdade(Data data){
         int diff = data.ano - this.data_nasc.ano;

         if (this.data_nasc.mes < data.mes){
             return diff;
         }
         if (this.data_nasc.mes > data.mes){
             return  diff-1;
         }
         if (this.data_nasc.dia <= data.dia){
             return diff;
         }
         return diff-1;
    }
}
