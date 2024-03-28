public class ContaCorrente{
    int NumeroConta;
    String NomeCliente;
    String CPF;
    double SaldoConta;

    public void Depositar (double valor){
    SaldoConta = SaldoConta + valor;
    }

    public void Sacar (double valor){
    SaldoConta = SaldoConta - valor;
    }

}

