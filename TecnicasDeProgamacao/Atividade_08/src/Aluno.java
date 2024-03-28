public class Aluno {
    private String nome;
    private double nota1, nota2, nota3;

    public Aluno(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public Aluno(String nome, double nota1, double nota2) {
        this(nome, nota1, nota2, 0);
    }

    public Aluno(String nome, double nota1) {
        this(nome, nota1, 0, 0);
    }

    public double calcularNotaFinal() {
        double notaFinal = (nota1 * 30 / 100) + (nota2 * 35 / 100) + (nota3 * 35 / 100);
        return notaFinal;
    }

    public boolean estaAprovado() {
        double notaFinal = calcularNotaFinal();
        double notaMinima = 60 * 0.6; // 60% da nota total
        return notaFinal >= notaMinima;
    }

    public double pontosFaltando() {
        double notaFinal = calcularNotaFinal();
        double notaMinima = 60 * 0.6; // 60% da nota total
        double pontosFaltando = notaMinima - notaFinal;
        return pontosFaltando;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
}

   
