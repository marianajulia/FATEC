//calcular dias de vida 
import java.util.Scanner;
public class EX05 {
    public static void main(String[] args){
        double d,m,a,dv;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o dia de hoje: ");
        d = sc.nextDouble();

        System.out.println("Digite o mes em que estamos: ");
        m = sc.nextDouble();

        System.out.println("Digite sua idade: ");
        a = sc.nextDouble();

        dv = (a * 365) + (m * 30) + d;
        System.out.println("Você tem " + dv + "dias de vida");


    }
    
}
//não consegui chegar no valor exato
