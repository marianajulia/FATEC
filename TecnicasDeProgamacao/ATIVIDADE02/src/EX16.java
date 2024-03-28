//colocar numeros em ordem crescente
import java.util.Arrays;
import java.util.Scanner;
public class EX16{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);

        int[] valores = new int[3]; //cria uma lista chamada valores que tem 3 espaços
        for (int i = 0; i < valores.length; i++){ // i++ = i + 1 
            System.out.println("Digite o " + (i + 1) + "º valor: ");
            valores[i] = sc.nextInt();
        }

        Arrays.sort(valores); // Ordena os valores em ordem crescente

        System.out.println("Valores em ordem crescente: \t");
        for (int valor : valores) { //vai percorrer a lista e imprimir os valores que estão nela
            System.out.println(valor);
        }




    }
}