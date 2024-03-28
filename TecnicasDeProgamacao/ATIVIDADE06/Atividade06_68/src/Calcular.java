//Calcular.java
public class Calcular {
    private Aluno aluno;

    public Calcular(Aluno aluno) {
        this.aluno = aluno;
    }

    public double calcularMedia(){
        double n1 = aluno.getNota1();
        double n2 = aluno.getNota2();

        double media = (n1 + n2)/2;
        return media;
    }



    public void calcularMediaFinal(){
        double n3 = aluno.getNotaReavaliação();
        if(calcularMedia() >= 6){
            System.out.println("Media Final: " + calcularMedia() );
        }else{
            double mf = (calcularMedia() + n3)/2;
            System.out.println("Media Final: " + mf); 
        }
    }



    
}
