//Calcular valor de prestação atrasada

import java.util.Scanner;
public class EX07 {
    public static void main(String[] args){
        double v,tx,tp,p;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor da sua compra: ");
        v = sc.nextDouble();

        System.out.println("Digite o valor da taxa da sua compra: ");
        tx = sc.nextDouble();

        System.out.println("Digite o tempo de atraso em meses: ");
        tp = sc.nextDouble();

        p = v + (v * (tx/100) * tp);

        System.out.println("O valor da prestação é: " + p + " R$");

    }
    
}
