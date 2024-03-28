public class Funcionario{
    String nome;
    double salarioBruto;
    double desconto;

    public void salarioLiquido (){
        double sl =  salarioBruto - desconto;
        System.out.println("Salario Liquido: " + sl);

    }


    public void aumentarSalario(double porcentagem){
        double salarioAumentado = (((porcentagem/100) * salarioBruto) + salarioBruto);
        System.out.println("Salario Aumentado: " + salarioAumentado);
    }

}