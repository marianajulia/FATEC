import java.util.Scanner;
public class EX03 {
    public static void main(String[] args){
        double c,f;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a temperatura em Fahrenheit: ");
        f = sc.nextDouble();

        c = (f-32) * (5.0/9); 
        
        // somente o 5.0 precisa ter um ponto decimal .0
        // para indicar que é um número de ponto flutuante. 
        ///O 9 pode permanecer como um número inteiro. 

        System.out.println("A temperatura em Celsius é:  " + c);
    }
    
}
