public class array1 {

    public static void main(String[] args){
        double[] valores = new double[6];

        valores[0] = 5.4;
        valores[1] = 6.4;
        valores[2] = 7.0;
        valores[3] = 6.0;
        valores[4] = 6.6;
        valores[5] = 1.8;

        //acessando seu quinto elemento(numero de posição 4)
        System.out.println("Elemento 5 do array: " + valores[4]);

        //mostrar todos os elementos do array:
        for (double elemento: valores){
            System.out.println(elemento);
        }

        //somar elementos do array
        double total = 0;
        for(int i = 0; i < valores.length; i++){
            total = total + valores[i];
        }

        System.out.println("O total é: " + total);


    }
    
}
