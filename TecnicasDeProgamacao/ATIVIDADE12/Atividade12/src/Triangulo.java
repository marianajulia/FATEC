public class Triangulo extends Figura{
    private double base;
    private double altura;
    
    public Triangulo(String cor, double altura, double base){
        super(cor);
        this.altura= altura;
        this.base= base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double area(){
        double a = base * altura / 2; 
        return a;
    }

    public String toString() {
        return "Triangulo [base=" + base + ", altura=" + altura + "Area= " + area() +  "]";
    }

    
}


