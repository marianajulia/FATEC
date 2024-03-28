import java.util.Scanner;
public class EX24 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        int valor = sc.nextInt();

        int conta = valor % 2;


        if(conta == 0 ){
            System.out.println(valor + " É par");
        }else{
           System.out.println(valor + " É impar"); 
        }
    }
    
}
