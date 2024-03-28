import java.util.Scanner;
public class EX54 {
    public static void main(String[] args){
        int A [] = new int[5];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < A.length; i++){
            System.out.println("Digite o " + (i + 1) + "º valor: ");
            A[i] = sc.nextInt();
        }
        
        int B [] = new int[5];
        for(int i = 0; i < A.length; i++){
            int f  = 1;
            int num = A[i];

            for(int j = 1; j <=num; j++){ 
                //cria uma lista com o valor de num ex: se for o numero 5 vai criar  
                //uma lista de 1 a 5 e percorre por ela  
                f *= j;
            }

            B[i] = f;
        }

        System.out.println("Vetor A: ");
        for(int i = 0; i<A.length; i++){
        System.out.print(" " +A[i]);
        }

        System.out.println("\nVetor B: ");
        for(int i = 0; i<B.length; i++){
        System.out.print(" " + B[i] );
        }

    }
    
}
