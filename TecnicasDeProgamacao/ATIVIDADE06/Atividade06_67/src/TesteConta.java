
//TesteConta.java
import java.util.Scanner;
public class TesteConta {
    public static void main(String[] args) throws Exception {

        //Atributos Conta1
        ContaCorrente conta1 = new ContaCorrente();
        Conta contaum = new Conta(conta1);
        Scanner sc = new Scanner(System.in);

        conta1.setNomeCorrentista("Fernando");
        conta1.setNumeroDaConta("1234");
        conta1.setContaConjunta(false);
        conta1.setSaldo(1500.00);
        conta1.setSexo("Masculino");
        conta1.setIdade(29);

        //Atributos Conta2
        ContaCorrente conta2 = new ContaCorrente();
        Conta contadois = new Conta(conta2);

        conta2.setNomeCorrentista("Maria");
        conta2.setNumeroDaConta("5312");
        conta2.setContaConjunta(true);
        conta2.setSaldo(530.31);
        conta2.setSexo("Feminino");
        conta2.setIdade(45);

        //Atributos Conta3
        ContaCorrente conta3 = new ContaCorrente();
        Conta contatres = new Conta(conta3);

        conta3.setNomeCorrentista("João");
        conta3.setNumeroDaConta("9621");
        conta3.setContaConjunta(true);
        conta3.setSaldo(4325.12);
        conta3.setSexo("Masculino");
        conta3.setIdade(54);

    



        //Saque conta1
        System.out.println("Saldo inicial da Conta Corrente: " + conta1.getSaldo());
        System.out.println("Digite o valor do saque: ");
        double valor = sc.nextDouble();
        contaum.saque(valor);

        //Saldo conta1
        System.out.println("Saldo da Conta Corrente: " + conta1.getSaldo());
        contaum.saldo();

        //Deposito conta1
        System.out.println("Saldo inicial da Conta Corrente: " + conta1.getSaldo());
        System.out.println("Digite o valor do Deposito: ");
        double valord = sc.nextDouble();
        contaum.depositar(valord);
        System.out.println("Saldo da Conta Corrente: " + conta1.getSaldo());

        sc.close();
    }
}
