public class Quadrado extends Retangulo{
    private double lado;
    public Quadrado(String cor, double lado){
        super(cor, lado, lado);
        this.lado = lado;

    }
    public double getLado() {
        return lado;
    }
    public void setLado(double lado) {
        this.lado = lado;
    }
    
    @Override
    public String toString() {
        return "Quadrado [lado=" + lado + "]";
    }

    



    
    
}
