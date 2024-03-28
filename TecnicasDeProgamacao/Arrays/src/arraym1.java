import java.util.Scanner;
public class arraym1 {
    public static void main (String [] args){

        int[][] notas = new int[2][2];
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite as notas: ");
        for(int i = 0;i<notas.length;i++){
          for(int j = 0;j<notas[i].length;j++){
            notas[i][j]= sc.nextInt();
          }  
        }

        System.out.println("Notas: ");
        for(int i = 0; i<notas.length;i++){
            for(int j = 0; j<notas.length;j++){
                System.out.print(notas[i][j]+"\t");
            }

            System.out.println(); // Adiciona uma quebra de linha após cada linha da matriz
        }
        
    }

    
}
