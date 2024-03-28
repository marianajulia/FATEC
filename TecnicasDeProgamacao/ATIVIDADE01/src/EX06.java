//Calcular area da circunferencia
import java.util.Scanner;
public class EX06 {
    public static void main(String[] args){
        double a, r;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o raio da circunferência: ");
        r = sc.nextDouble();

        a = 3.14 * r * r;

        System.out.println("A area da circunfência é: " + a);
    }
}
