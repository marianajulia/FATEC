import java.util.Scanner;
public class EX23 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        for(int i = 1; i <= 5; i++){
            System.out.print("Digite o " + i + "º valor: ");
            int valor = scanner.nextInt();

            maior = Math.max(maior, valor);
            menor = Math.min(menor, valor);
        }

        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
    }
    
}
