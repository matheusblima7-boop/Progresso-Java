import java.util.Scanner;
import java.util.Locale;

public class Calculadora {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        double num1, num2;
        String operador;

        System.out.printf("Digite o primeiro numero: %n");
        num1 = sc.nextDouble();
        
        System.out.printf("Digite o operador: %n");
        operador = sc.next();
        
        if (operador.equals("+")) {
            System.out.printf("Digite o segundo numero: %n");
            num2 = sc.nextDouble();

            System.out.printf("O resultado da conta é: %.2f",num1 + num2);
        }
        else if (operador.equals("-")) {
            System.out.printf("Digite o segundo numero: %n");
            num2 = sc.nextDouble();

            System.out.printf("O resultado da conta é: %.2f",num1 - num2);
        }
        else if (operador.equals("*")) {
            System.out.printf("Digite o segundo numero: %n");
            num2 = sc.nextDouble();

            System.out.printf("O resultado da conta é: %.2f",num1 * num2);
        }
        else if (operador.equals("/")) {
            System.out.printf("Digite o segundo numero: %n");
            num2 = sc.nextDouble();

            System.out.printf("O resultado da conta é: %.2f",num1 / num2);
        }
        else if (operador.equals("^")) {
            System.out.printf("Digite o segundo numero: %n");
            num2 = sc.nextDouble();

            System.out.printf("O resultado da conta é: %.2f%n", Math.pow(num1, num2));
        }
        else if (operador.equals("%")) {
            System.out.printf("Digite o segundo numero: %n");
            num2 = sc.nextDouble();

            System.out.printf("O resultado da conta é: %.2f%n", num1 * num2 / 100);
        }
        else if (operador.equals("√")) {
            System.out.printf("O resultado da conta é: %.2f%n", Math.sqrt(num1));
        }
        else {
            System.out.println("Operador não identificado.");
        }


    }
}
