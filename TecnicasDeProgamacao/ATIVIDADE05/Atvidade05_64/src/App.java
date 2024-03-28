import java.util.Locale;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        
        System.out.println("Digite nome do Funcionario: ");
        funcionario.nome = sc.nextLine();
        

        System.out.println("Digite salario bruto: ");
        funcionario.salarioBruto = sc.nextDouble();

        System.out.println("Digite o desconto: ");
        funcionario.desconto = sc.nextDouble();
        

        System.out.println("Nome funcionário: " + funcionario.nome);
        funcionario.salarioLiquido();

        System.out.println("Digite a porcentagem: ");
        double porcentagem = sc.nextDouble();
        

        System.out.println("Nome funcionário: " + funcionario.nome);
        funcionario.salarioLiquido();
        funcionario.aumentarSalario(porcentagem);

        sc.close();


    }
}
