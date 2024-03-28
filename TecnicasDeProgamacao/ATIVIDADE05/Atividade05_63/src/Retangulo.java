public class Retangulo{
    double altura;
    double largura;

    public  void CalcularArea(){
        double area =  altura * largura;
        System.out.println("AREA = " + area);
    }

    public void CalcularPerimetro(){
        double perimetro = 2 * (altura + largura);
        System.out.println("PERIMETRO = " + perimetro);
    }

    public void CalcularDiagonal(){
        double a = altura;
        double l = largura;
        double diagonal = Math.sqrt((a*a) + (l*l));
        System.out.println("DIAGONAL = " + diagonal);
    }
}