import java.util.Locale;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Retangulo retangulo = new Retangulo();

        System.out.println("Digite a altura: ");
        retangulo.altura = sc.nextDouble();

        System.out.println("Digite a largura: ");
        retangulo.largura = sc.nextDouble();

        retangulo.CalcularArea();
        retangulo.CalcularDiagonal();
        retangulo.CalcularPerimetro();

        sc.close();
    }
}
