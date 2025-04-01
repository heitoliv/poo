package banco;

public class Data {
    int dia;
    int mes;
    int ano;

    Data(){
        this.dia = -1;
        this.mes = -1;
        this.ano = -1;
    }

    Data(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    void imprimeData(){
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
    }


}
