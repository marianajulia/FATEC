public class Aluno {
    String RA;
    String Nome;
    String Endereço;
    String Curso;
    boolean CursoTrancado;

    public void TrancarCuro (){
        CursoTrancado = true;
    }

    public void ImprimirStatusCurso(){
        if(CursoTrancado){
            System.out.println("Curso Trancado");
        }else{
            System.out.println("Curso Ativo");
        }
    }
}

