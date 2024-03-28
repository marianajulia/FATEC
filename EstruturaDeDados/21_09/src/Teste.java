import java.util.Scanner;
public class Teste{
   public static void main(String[] args){
      ListaDeAlunos lista1 = new ListaDeAlunos(5);
      int op;
      Scanner sc = new Scanner(System.in);
      do{
         System.out.println("1-Adicionar no final");
         System.out.println("2-Remover do final");
         System.out.println("3-Consulta a lista");
         System.out.println("4-Sair");
         op=sc.nextInt();
         sc.nextLine();
      try{
         switch(op){
            case 1: /*adicionar */
            System.out.println("Nome: ");
            String nome = sc.nextLine();

            System.out.println("RA: ");         
            String ra = sc.nextLine();

            Aluno aluno = new Aluno(nome, ra);
            lista1.adicionaFinal(aluno);
            break;

            case 2: /*remover */
            Aluno removido = lista1.removeFinal();
            System.out.println("Elemento removido: "  + removido);
            break;

            case 3: /* consultar */
            if (lista1.vazia()){
               System.out.println("Não há elementos na lista");
              } else {
                System.out.println("Lista: " + lista1.toString());
            }
            break;
            
            case 4:
            System.out.println("Saindo....");
            break;
            default:
            System.out.println("Opção Inválida");
         }
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
   }while(op != 4);

   sc.close();
}
}