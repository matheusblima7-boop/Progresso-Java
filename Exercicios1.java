import java.util.Locale;
import java.util.Scanner;

public class Exercicios1 {
    public static void main (String[] args){

        //===============================================================================
        // EXERCÍCIO 1 SAÍDA DE DADOS
        // ===============================================================================
        String product1 = "Computer";
        String product2 = "Office desk";

        int age = 30;
        int code = 5290;
        char gender = 'F';

        double price1 = 2100.0;
        double price2 = 650.50;
        double measure = 53.234567;

        System.out.printf("Products: %s, which price is %.2f%n", product1, price1);
        System.out.printf("%s, which price is $%.2f%n", product2, price2);
        System.out.printf("Record: %d years old, code %d and gender: %c%n", age, code, gender);

        System.out.printf("Measure with eight decimal places: %f%n", measure);
        System.out.printf("Rounded (Three decimal places): %.3f%n", measure);
        Locale.setDefault(Locale.US);
        System.out.printf("US decimal point: %.3f%n", measure);

        // ==============================================================================
        // EXERCÍCIO TRAPÉZIO
        // ==============================================================================
        // OBS: Mesmo se o número for inteiro, se a variável for double, coloque um ".0" pra identificar que é um número double.
        double al, AL, h;

        al = 6.0;
        AL = 8.0;
        h = 5.0;

        double area = (double) ((al + AL) / 2) * h;
        System.out.printf("Area: %.1f%n", area);

        // ===============================================================================
        // EXERCÍCIO BHASKARA
        // ===============================================================================
        double x1, x2, delta, A, B, C;

        A = 1;
        B = 12;
        C = -13;

        delta = Math.pow(B, 2.0) - 4 * A * C;
        x1 = (-B + Math.sqrt(delta)) / (2 * A);
        x2 = (B - Math.sqrt(delta)) / (2 * A);

        System.out.println("x1 = " + x1 + " x2 = " + x2);

        // ====================================================
        // EXERCÍCIO LARGURA E COMPRIMENTO
        // ====================================================
        System.out.println("Por favor digite os seguintes valores: largura, compirmento e metro quadrado.");
        Scanner sc = new Scanner(System.in);
        double largura, comprimento, Area, preco, metroquadrado;

        largura = sc.nextDouble();
        comprimento  = sc.nextDouble();
        metroquadrado = sc.nextDouble();

        Area = largura * comprimento;

        preco = Area * metroquadrado;
        System.out.println("Area = " + Area);
        System.out.println("Preço = " + preco);

        // =======================================================
        // Exercícios Matemática
        // =======================================================
        // Soma
        System.out.println("Digite números pra somar");
        int n1, n2, soma;
        n1 = sc.nextInt();
        n2 = sc.nextInt();

        soma = n1 + n2;
        System.out.println("Soma = " + soma);

        // Raio
        System.out.println("Digite o raio do círculo");
        double pi, raio, areaCirculo;

        pi = 3.14159;
        raio = sc.nextDouble();
        areaCirculo = pi * Math.pow(raio, 2);

        System.out.printf("Area = %.4f%n", areaCirculo);

        // Diferença
        System.out.println("Digite 4 números para obter a diferença");
        int N1, N2, N3, N4, diferenca;
        N1 = sc.nextInt();
        N2 = sc.nextInt();
        N3 = sc.nextInt();
        N4 = sc.nextInt();

        diferenca = N1 * N2 - N3 * N4;
        System.out.println("Diferença = " +  diferenca);

        // Exercício salário funcionário
        System.out.println("Digite o número de id.; as horas trabalhadas e o salário por hora");
        int number;
        double horas, salario_hora, salario;

        number = sc.nextInt();
        horas = sc.nextDouble();
        salario_hora = sc.nextDouble();

        salario = salario_hora * horas;

        System.out.printf("NUMBER: %d%n", number);
        System.out.printf("SALARY = U$ %.2f%n", salario);

        // Exercício peças
        System.out.println("Digite o cód. da peça 1, número de peças 1, o valor unitário da peça 1; O mesmo para a peça 2.");
        int codigo1, codigo2, qntd1, qntd2;
        double valor1, valor2, valor_total;

        codigo1 = sc.nextInt();
        qntd1 = sc.nextInt();
        valor1 = sc.nextDouble();

        codigo2 = sc.nextInt();
        qntd2 = sc.nextInt();
        valor2 = sc.nextDouble();

        valor_total = (qntd1 * valor1) + (qntd2 * valor2);
        System.out.printf("VALOR A PAGAR: R$ %.2f%n", valor_total);

        // Exercício áreas
        System.out.println("Digite A, B e C.");
        double v1, v2, v3, pi1;
        double triangulo, circulo, trapezio, quadrado, retangulo;
        pi1 = 3.14159;

        v1 = sc.nextDouble();
        v2 = sc.nextDouble();
        v3 = sc.nextDouble();

        triangulo = v1 * v2 / 2.0;
        circulo = pi1 * Math.pow(v3, 2.0);
        trapezio = (v1 + v2) * v3 / 2.0;
        quadrado = Math.pow(v2, 2.0);
        retangulo = v1 * v2;

        System.out.printf("TRIANGULO: %.3f%n CIRCULO: %.3f%n TRAPEZIO: %.3f%n QUADRADO: %.3f%n RETANGULO: %.3f%n", triangulo, circulo, trapezio, quadrado, retangulo);
    }
}
