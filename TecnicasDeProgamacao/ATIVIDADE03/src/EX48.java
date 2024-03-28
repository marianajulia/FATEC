public class EX48 {
    public static void main(String[] args){

        int A [] = new int[10];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 4;
        A[4] = 5;
        A[5] = 6;
        A[6] = 7;
        A[7] = 8;
        A[8] = 9;
        A[9] = 10;

        int B[] = new int[10];

        for(int i = 0; i<A.length; i++){
        B[i] = A[i] * 2;
        }

        System.out.println("Coleção A: ");
        for(int i = 0; i<A.length; i++){
        System.out.print(" " +A[i]);
        }

        System.out.println("\nColeção B: ");
        for(int i = 0; i<B.length; i++){
        System.out.print(" " + B[i] );
        }
    }
    
}
