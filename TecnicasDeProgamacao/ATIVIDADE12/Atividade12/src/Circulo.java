public class Circulo extends Figura{
    private double raio;
    
    public Circulo(String cor, double raio){
        super(cor);
        this.raio=raio;
    }

    public void setRaio(double raio){
        this.raio= raio;
    }

    public double getRaio(){
        return raio;
    }

    public double getDiametro(){
        double d = 2 * raio;
        return d;
    }


    public double area(){
        double a = 3.14 * raio * raio;
        return a;
    }

    @Override
    public String toString() {
        return "Circulo [raio=" + raio + "Cor= " + getCor() + "Area= " + area() + "]";
    }

}