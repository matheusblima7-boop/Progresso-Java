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
        System.out.printf("Digite o segundo numero: %n");
        num2 = sc.nextDouble();

        if (operador.equals("+")) {
            System.out.printf("O resultado da conta é: %.2f",num1 + num2);
        }
        else if (operador.equals("-")) {
            System.out.println("O resultado é:");
            System.out.println(num1 - num2);
        }
        else if (operador.equals("*")) {
            System.out.println("O resultado é:");
            System.out.println(num1 * num2);
        }
        else if (operador.equals("/")) {
            System.out.println("O resultado é:");
            System.out.println(num1 / num2);
        }
        else {
            System.out.println("Operador não identificado.");
        }


    }
}
