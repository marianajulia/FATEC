public class ListaDeInteiros{ //a classe é a lista de inteiros 
    //Atributos 

    private int dados []; //nome da lista 
    private int tamanho; //nome do indice que vai ficar o valor 

    //construtor
    
    public ListaDeInteiros(int capMax){ //construtor para passar os parametros
        dados = new int[capMax];
    }

    //métodos

    public void adicionaFinal(int e) throws Exception{
        if(dados.length != tamanho){
            dados[tamanho] = e; /* Ele atribui o valor e à posição tamanho do array dados.*/
            tamanho = tamanho +1;
        }else{
            throw new Exception("A lista está cheia!");
        }
    }

    public String toString(){
        String s = "Elementos";
        for(int i = 0; i< tamanho;i++){
            s = s + " " + dados[i]; /*Dentro do loop, o código concatena o valor de dados[i] à string s. 
            Isso significa que cada elemento da lista é adicionado à representação de string separado por 
            espaços. */
        }
        s = s + "\nTamanho: " + tamanho;
        return s;
    }

    public int removeFinal() throws Exception{
        if(tamanho !=0){
            tamanho = tamanho - 1;
            return dados[tamanho];
        }else{
            throw new Exception("ERRO! Lista Vazia");
        }
    }


    

}



