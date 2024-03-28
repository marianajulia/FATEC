//refazer

import java.util.Scanner;
public class EX27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cardápio da Lanchonete:");
        System.out.println("Especificação          Código           Preço");
        System.out.println("Cachorro quente     100                 1,20");
        System.out.println("Bauru simples          101                 1,30");
        System.out.println("Bauru com ovo        102                 1,50");
        System.out.println("Hambúrger               103                 1,20");
        System.out.println("Cheeseburguer        104                 1,30");
        System.out.println("Refrigerante             105                 1,00");

        System.out.print("Digite o código do item pedido: ");
        int codigo = scanner.nextInt();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        double valorTotal = calcularValorTotal(codigo, quantidade);

        if (valorTotal > 0) {
            System.out.println("Valor a ser pago: " + valorTotal);
        } else {
            System.out.println("Código de item inválido.");
        }
    }

    public static double calcularValorTotal(int codigo, int quantidade) {
        double preco = 0.0;

        if (codigo == 100) {
            preco = 1.20;
        } else if (codigo == 101) {
            preco = 1.30;
        } else if (codigo == 102) {
            preco = 1.50;
        } else if (codigo == 103) {
            preco = 1.20;
        } else if (codigo == 104) {
            preco = 1.30;
        } else if (codigo == 105) {
            preco = 1.00;
        } 

        return preco * quantidade;
    }
}

