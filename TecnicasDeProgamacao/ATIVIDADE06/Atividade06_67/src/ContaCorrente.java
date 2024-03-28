//ContaCorrente.java
public class ContaCorrente{
    private String nomeCorrentista;
    private String sexo;
    private int idade;
    private String numeroDaConta;
    private boolean contaConjunta;
    private double saldo;


    public String getNomeCorrentista() {
        return nomeCorrentista;
    }
    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public String getSexo(){
        return sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getNumeroDaConta(){
        return numeroDaConta;
    }
    public void setNumeroDaConta(String numerroDaConta){
        this.numeroDaConta = numerroDaConta;
    }

    public boolean getContaConjunta(){
        return contaConjunta;
    }
    public void setContaConjunta(boolean contaConjunta){
        this.contaConjunta = contaConjunta;
    }

    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

}