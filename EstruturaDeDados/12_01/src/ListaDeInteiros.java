public class ListaDeInteiros {
    private int dados[];
    private int tamanho;
 
    public ListaDeInteiros(int capMax){
        dados = new int[capMax];
        //o java pré inicializa os atributos do tipo inteiro
        //com o valor 0 (zero), do tipo real com o 
        //valor 0.0(zero ponto zero) e atributos com tipo
        //abstrato de dados são inicializados com null
        //Portanto tamanho recebeu o valor 0(zero)
        
    }


//Inclua este método na classe ListaDeInteiros
public void adicionaFinal (int e)throws Exception{
    if (!cheia()) {
    // não está cheia
    dados[tamanho] = e;
    tamanho = tamanho + 1;
    } else {
    //sim está cheia
    throw new Exception("ERRO! Lista Cheia");
    }
    }

    public String toString(){
        String s = "Elementos: ";
        for (int i = 0; i<tamanho; i++){
            s = s + " " + dados[i];
        }
        s = s + "\nTamanho: " + tamanho;
        return s;
    }


    public int removeFinal() throws Exception{
        if(!vazia()){
            //não esta vaia
            tamanho = tamanho - 1;
            return dados[tamanho];
        }else{
            //sim está vazia
            throw new Exception("ERRO! Lista Vazia");
        }
    }



    public boolean vazia(){
        return tamanho == 0;
    }

    public boolean cheia(){
        return tamanho == dados.length;
    }

    public int obtemUltimo() throws Exception{
        if(vazia())
            throw new Exception("Erro, Lista vazia!");
        else
            return dados[tamanho-1];
    }

    public int obtemPrimeiro() throws Exception{
        if(vazia())
            throw new Exception("Erro, Lista vazia!");
        else
            return dados[0];
    }

    public int removeInicio() throws Exception{
        if (vazia())
            throw new Exception("Erro! Lista Vazia");
        else{
            //guarda o elemento que será removido para retoná-lo no final
            int r = dados[0];
            //move um elemento a esquerda quando a lista tiver mais que um elemento
            for(int i=0;i<tamanho-1;i++){
                dados[i] = dados[i+1];
            }
            //decrementar o tamanho para ajusta-lo à quantidade de elementos
            tamanho--;
            return r;
        }
    }
 
}
