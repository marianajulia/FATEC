//Aluno.java
public class Aluno{
    private String nome;
    private String matricula;
    private double nota1;
    private double nota2;
    private double notaReavaliação;

    public Aluno() {
    }

    public Aluno(String nome, String matricula, double nota1, double nota2, double notaReavaliação){
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaReavaliação = notaReavaliação;
    }


    public String toString(){
        return "Nome: " + nome + "\nMatricula" + matricula + "\nNota1: " + nota1 + "\nNota2: " + nota2 + "\nNota Reavaliação: " + notaReavaliação;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNotaReavaliação(){
        return notaReavaliação;
    }
    public void setNotaReavaliação(double notaReavaliação){
        this.notaReavaliação = notaReavaliação;
    }

    
}