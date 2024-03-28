//refazer
import java.util.Scanner;

public class EX31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        if (numero == 0 || numero == 1) {
            System.out.println("1");
        } else {
            long fatorial = 1;
            
            for (int i = 2; i <= numero; i++) {
                fatorial *= i;
            }
            System.out.println("O fatorial de " + numero + " é: " + fatorial);
    }
}

}