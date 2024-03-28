//App.java
public class App {
    public static void main(String[] args) throws Exception {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Mariana");
        aluno1.setNota1(5.0);
        aluno1.setNota2(5.0);
        aluno1.setNotaReavaliação(9.0);

        Calcular cal = new Calcular(aluno1);
        cal.calcularMediaFinal();


    }
}
