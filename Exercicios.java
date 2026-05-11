import java.util.Locale;

public class Exercicios {
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

        //===============================================================================
        // EXERCÍCIO EXTRA TRAPÉZIO
        // ===============================================================================
        // OBS: Mesmo se o número for inteiro, se a variável for double, coloque um ".0" pra identificar que é um número double.
        double b, B, h;

        b = 6.0;
        B = 8.0;
        h = 5.0;

        double area = (double) ((b + B) / 2) * h;
        System.out.printf("Area: %.1f%n", area);
    }
}
