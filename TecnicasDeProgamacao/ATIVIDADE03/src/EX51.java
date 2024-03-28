import java.util.Scanner;
public class EX51 {
    public static void main(String[] args){
        
        double p1[]= new double[5];
        double p2[] = new double[5];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < p1.length; i++){
            System.out.println("Digite a nota de p1 do " + (i + 1) + "º aluno: ");
            p1[i] = sc.nextDouble();
        }

        for(int i = 0; i < p1.length; i++){
            System.out.println("Digite a nota de p2 do " + (i + 1) + "º aluno: ");
            p2[i] = sc.nextDouble();
        }
        
        double m[] = new double[5];
        for(int i = 0; i < p1.length; i++){
        double n = p1[i] + p2[i];  
        m[i] = n / 2.0;
        System.out.println("A media do" +(i+1)+ "º Aluno é: " + m[i]);
        }
   }
    
    
}
