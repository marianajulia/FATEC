import java.util.Scanner;
public class EX04 {
    public static void main(String[] args){
        double a,r,v;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digita a altura da lata: ");
        a = sc.nextDouble();

        System.out.println("Digite o raio da lata: ");
        r = sc.nextDouble();

        v = 3.14159 * r * r * a;

        System.out.println("O volume da lata é: " + v + " metros³");

    }


    
}
