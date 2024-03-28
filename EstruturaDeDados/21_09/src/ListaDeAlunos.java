import java.util.Arrays;

public class ListaDeAlunos{
    private Aluno dados[];
    private int tamanho;

    public ListaDeAlunos(int capMax){
        dados = new Aluno[capMax];
    }

    public void adicionaFinal (Aluno e)throws Exception{
        if (!cheia()) {
        // não está cheia
        dados[tamanho] = e;
        tamanho = tamanho + 1;
        } else {
        //sim está cheia
        throw new Exception("ERRO! Lista Cheia");
        }
    }

    public Aluno removeFinal ( )throws Exception{
        if (!vazia()) {
        // não está vazia
        tamanho = tamanho - 1;
        return dados[tamanho] ;
        } else {
        //sim está vazia
        throw new Exception("ERRO! Lista Vazia");
        }
    }

    public boolean cheia(){
        return tamanho == dados.length;
    }

    public boolean vazia(){
        return tamanho == 0;
    }

    @Override
    public String toString() {
        return "ListaDeAlunos [dados=" + Arrays.toString(dados) + "]";
    }

    
    
}

