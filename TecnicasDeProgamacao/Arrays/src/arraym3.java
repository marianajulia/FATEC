/*Elabore um programa que leia elementos e os guarde 
em uma matriz quadrada de ordem 3 do tipo inteiro */
import java.util.Scanner;
public class arraym3 {
    public static void main(String[] args){
        int [][] valores = new int[3][3];
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite valores: ");
        for(int i = 0; i < valores.length; i++){
            for(int j = 0; j <valores[i].length; j++){
                valores [i][j]= sc.nextInt();     
            }
        }

        System.out.println("Valores: ");
        for(int i = 0; i < valores.length; i++){
            for(int j = 0; j < valores[i].length; j++){
                System.out.print(valores[i][j] + "\t");

            }
            
            System.out.println();
        }
    }
    
}
