import java.util.Scanner;
public class EX01 {
    public static void main(String args[]){
        int a,b,c;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o primeiro valor: ");
        a = sc.nextInt();

        System.out.println("Digite o segundo valor: ");
        b = sc.nextInt();

        c = a * b;

        System.out.println("O resultado da multiplicação é: " + c);

    }

}
