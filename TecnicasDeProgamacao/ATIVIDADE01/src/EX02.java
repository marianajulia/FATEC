
import java.util.Scanner;
public class EX02 {
    public static void main(String[] args){
        double c,f;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a temperatura em Celsius: ");
        c = sc.nextDouble();

        f = (9*c + 160) / 5;

        System.out.println("A temperatura em Fahrenheit é: " + f );
    }
    
}
