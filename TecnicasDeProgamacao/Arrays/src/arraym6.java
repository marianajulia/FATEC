/*Elabore um programa que leia elementos e os guarde 
em uma matriz quadrada de ordem 3 do tipo inteiro e faça a media da matriz  */

import java.util.Scanner;
public class arraym6 {
    public static void main(String[] args){
        int [][] valores = new int[3][3];
        int listasoma [] = new int [valores.length];
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite valores: ");
        for(int i = 0; i < valores.length; i++){
            for(int j = 0; j <valores[i].length; j++){
                valores [i][j]= sc.nextInt();     
            }
        }

        for(int i = 0; i < valores.length; i++){
            int soma  = 0;
            for(int j = 0; j<valores[i].length;j++){
                soma = soma + valores[i][j];
            }
            listasoma [i] = soma;
        }

        int somamatriz = 0;
        for(int i = 0; i < valores.length; i++){
            somamatriz += listasoma[i];
        }


        int media = somamatriz / (valores.length * valores[0].length);

        System.out.println("Média da Matriz: " + media);
    

    }
    
}
