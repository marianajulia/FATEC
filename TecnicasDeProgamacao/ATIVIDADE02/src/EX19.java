import java.util.Scanner;
public class EX19 {
    public static void main(String [] args){
        double n1, n2, n3, n4, m;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a primeira nota: ");
        n1 = sc.nextDouble();

        System.out.println("Digite a segunda nota: ");
        n2 = sc.nextDouble();

        System.out.println("Digite a terceira nota: ");
        n3 = sc.nextDouble();

        System.out.println("Digite a quarta nota: ");
        n4 = sc.nextDouble();

        m = (n1 + n2 + n3 + n4)/4;

        if(m >= 7){
            System.out.println("Aprovado!");
        }else{
            System.out.println("Não foi aprovado");
        }




    }
    
}
