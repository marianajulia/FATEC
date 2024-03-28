//resto da divisão por 6
import java.util.Scanner;
public class EX11 {
    public static void main(String[] args){
        int a,b;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        a = sc.nextInt();

        b = a % 6;

        System.out.println(" o resto da divisão por 6 é: " + b);
    }

    
}

