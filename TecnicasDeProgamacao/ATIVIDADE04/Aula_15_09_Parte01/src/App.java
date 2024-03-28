public class App {
    public static void main(String[] args) {
    ContaCorrente C1 = new ContaCorrente(); //Instanciação

    C1.NumeroConta = 1234;
    C1.NomeCliente = "Mariana Julia";
    C1.CPF = "50953078567";
    C1.SaldoConta = 300.0;

    System.out.println("Número da conta: " + C1.NumeroConta);
    System.out.println("Nome do Cliente: " + C1.NomeCliente);
    System.out.println("CPF: " + C1.CPF);
    System.out.println("Saldo da conta: " + C1.SaldoConta);

    C1.Depositar(100);
    System.out.println("Depositar 100,00 R$: " + C1.SaldoConta + "R$");

    C1.Sacar(50);
    System.out.println("Sacar 50,00 R$:  " + C1.SaldoConta + "R$");

    }
}
