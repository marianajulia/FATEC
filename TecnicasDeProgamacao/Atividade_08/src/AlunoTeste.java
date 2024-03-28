public class AlunoTeste {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João", 27, 31, 32);
        System.out.println("Nota final de " + aluno1.getNome() + ": " + aluno1.calcularNotaFinal());
        if (aluno1.estaAprovado()) {
            System.out.println("Aluno aprovado!");
        } else {
            System.out.println("Aluno reprovado. Pontos faltando: " + aluno1.pontosFaltando());
        }

        Aluno aluno2 = new Aluno("Pedro", 17, 20, 15);
        System.out.println("Nota final de " + aluno2.getNome() + ": " + aluno2.calcularNotaFinal());
        if (aluno2.estaAprovado()) {
            System.out.println("Aluno aprovado!");
        } else {
            System.out.println("Aluno reprovado. Pontos faltando: " + aluno2.pontosFaltando());
        }
    }
}
