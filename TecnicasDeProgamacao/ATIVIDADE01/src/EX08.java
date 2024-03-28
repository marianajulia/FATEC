import java.util.Scanner;

public class EX08 {
    public static void main(String[] args) {
        double c, q, r;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a cotação do dólar: ");
        c = sc.nextDouble();

        System.out.println("Digite o valor que você possui em dólar: ");
        q = sc.nextDouble();

        r = c * q;

        System.out.println("Você tem " + r + "R$");
    }
}
