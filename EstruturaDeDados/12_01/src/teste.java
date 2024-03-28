import java.util.Scanner;
public class teste {
    public static void main(String args[]){
        ListaDeInteiros lista1 = new ListaDeInteiros(5);
        int op, valor;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1-Adicionar no final\n2-Adicionar no início\n3-Remover do final");
            System.out.println("4-Remover do início\n5-Consulta a lista\n6-Sair");
            System.out.println("6-Consultar o último elemento");
            System.out.println("7-Consultar o primweiro elemento\n99-Sair");
            op=sc.nextInt();
            try{
                switch(op){
                    case 1: 
                       System.out.println("Valor? ");
                       valor = sc.nextInt();
                       lista1.adicionaFinal(valor);
                       break;
                    case 2:
                       System.out.println("Em implementação ");
                       break;
                    case 3:
                       valor = lista1.removeFinal();
                       System.out.println("Elemento removido "+valor);
                       break;   
                    case 4:
                       valor = lista1.removeInicio();
                       System.out.println("Elemento removido" + valor);
                       break;
                    case 5:
                       if (lista1.vazia()){
                        System.out.println("Não há elementos na lista");
                       }else{
                       System.out.println("Lista: " + lista1.toString());
                       }
                       break;
                    case 6:
                       System.out.println("Último elemento " + lista1.obtemUltimo());
                       break;
                    case 7:
                       System.out.println("Primeiro Elemento" + lista1.obtemPrimeiro());
                       break;
                    case 99:
                       System.out.println("Saindo.... ");
                       break;
                    default:
                       System.out.println("Opção Inválida");
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
       } while(op != 99);
    }
}
