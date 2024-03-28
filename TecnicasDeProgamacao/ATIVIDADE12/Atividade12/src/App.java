public class App {
    public static void main(String[] args) throws Exception {


        Circulo c1 = new Circulo("rosa", 2);
        Triangulo t1 = new Triangulo("verde", 10, 6);
        Retangulo r1 = new Retangulo("amarelo", 10, 6);
        Quadrado q1 = new Quadrado("verde", 10);

        System.out.println(c1.toString());
        System.out.println(t1.toString());
        System.out.println(r1.toString());
        System.out.println(q1.toString());

    }
}
