public class App {
    public static void main(String[] args) throws Exception {
        Aluno A = new Aluno();

        A.RA = "21712345";
        A.Nome = "Mariana Julia";
        A.Endereço = "Rua Paula, 25";
        A.Curso = "Administração";

        System.out.println("RA: " + A.RA);
        System.out.println("Nome: " + A.Nome);
        System.out.println("Endereço: " + A.Endereço);
        System.out.println("Curso: " + A.Curso);

        System.out.println("Status Curso: ");
        A.ImprimirStatusCurso();

        A.TrancarCuro();
        System.out.println("Status Curso: ");
        A.ImprimirStatusCurso();
    }
}
