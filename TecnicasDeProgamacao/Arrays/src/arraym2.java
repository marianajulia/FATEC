public class arraym2 {
    
    public static void main(String[] args){

        String[][] agenda = {{"José", "1234" , "José@"}/*linha 1 */, {"Bill", "5678", "Bill@"},/*linha 2 */ {"Linus", "91011", "Linus@"}};

        /*A linha abaixo recupera o telefone do José */
        /*System.out.println(agenda[0][1]);*/

        /*As estruturas abaixo percorrem os indices dos arrays */
        for(int i = 0;i<agenda.length;i++){
            System.out.println("------------------------------------");
            for(int j = 0; j<agenda[i].length;j++){
                System.out.println(agenda[i][j]);
            }
        }


    }
}
