
public class FilaDeInteiros {
    int dados[];
    int tamanho;

    public FilaDeInteiros (int capMax){
        dados = new int[capMax];
        tamanho = 0;
    }

    public boolean cheia(){
        return tamanho == dados.length;
    }

    public boolean vazia(){
        return tamanho == 0;
    }

    public void adiciona(int e) throws Exception{
        if(!cheia()){
            dados[tamanho] = e;
            tamanho = tamanho + 1;
        }else{
            throw new Exception("ERRO! Lista cheia");
        }
    }

    public int remove() throws Exception{
        if(vazia()){
            throw new Exception("ERRO! Lista vazia");
        }else{
            int r = dados[0];
            for(int i = 0; i<tamanho -1; i++){
                dados[i]=dados[i+1];
            }

            tamanho--;
            return r;
        }
    }

    public String toString(){
        String s = "Elementos";
        for(int i=0; i<tamanho;i++){
            s = s +" "+ dados[i];
        }
        s = s + "\nTamanho: " + tamanho;
        return s;
    }
    
}
