public class Gerente extends Funcionario{
    private int senha;

    public void setSenha(int senha){
        this.senha = senha;
    }

    public int getSenha (){
        return senha;
    }

    public double autenticar(int senhaDigitada){
        return this.senha= senhaDigitada;
    }
}
