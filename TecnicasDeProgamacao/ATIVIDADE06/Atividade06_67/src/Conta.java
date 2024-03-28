//Conta.java
public class Conta {

    private ContaCorrente contacorrente;

    public Conta(ContaCorrente contacorrente) {
        this.contacorrente = contacorrente;
    }

    public void saque(double valor){
        if(valor <= 0){
            System.out.println("Valor invalido! Não é possivel realizar saque");
            return;
        }
        double saldo = contacorrente.getSaldo();
        if(saldo >= valor){
            saldo = saldo - valor;
            System.out.println("Saque de " + valor + " R$ realizado com sucesso!");
            contacorrente.setSaldo(saldo);
        }else{
            System.out.println("Saldo insulficiente!");
        }
        
    }

    public void saldo(){
        String nomeCorrentista = contacorrente.getNomeCorrentista();
        String numeroDaConta = contacorrente.getNumeroDaConta();
        boolean contaConjunta = contacorrente.getContaConjunta();
        double saldo = contacorrente.getSaldo();

        System.out.println("Nome Correntista: " + nomeCorrentista);
        System.out.println("Numero da Conta: " + numeroDaConta);
        System.out.println("Conta Conjunta: " + contaConjunta);
        System.out.println("Saldo: " + saldo);
    }

    public void depositar(double valord){
        double saldo = contacorrente.getSaldo();
        if(valord <= 0){
            System.out.println("Valor invalido!");
        }else{
            saldo = saldo + valord;
            System.out.println("Deposito de " + valord + " R$ realizado com sucesso!");
            contacorrente.setSaldo(saldo);
        }
        
    }
}
