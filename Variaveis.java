import java.util.Scanner;
public class Variaveis {
    public static void main(String[] args) {

        // ==========================================================================
        // TIPOS DE VARIAVEIS
        // ====================================================================

        // Para números inteiros
        int idade = 16;

        // Para números decimais
        double altura = 1.80;

        // Para textos
        String nome = "Matheus";

        // Para Verdadeiro (True) ou Falso (False)
        boolean vivo = true;

        // Para um único character
        char sexo = 'M';

        // Para entrada de dados (digitar um valor para variável)
        // Para ela funcionar, colocar no início do código: import java.util.Scanner;
        // Faça sc.close() quando não precisar mais do objeto sc
        // Sempre colocar esse código abaixo quando quiser usar inputs.
        Scanner sc = new Scanner(System.in);

        // =======================
        // Variáveis Matemáticas
        // =======================

        // Valores definidos
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;

        // Variáveis que vão receber o resultado da conta
        double A, B, C;

        // Math.sqrt(variável do valor) faz raiz quadrada. Exemplo: A = Math.sqrt(x);
        // A variável "A" vai receber o valor da raiz quadrada de "x"

        A = Math.sqrt(x);
        B = Math.sqrt(y);
        C = Math.sqrt(z);

        // Math.pow é potência. Se digitarmos Math.pow(x, y), a conta vai ser x elevado a y.
        // Também podemos escrever números ao invés de variáveis
        A = Math.pow(x, y);
        B = Math.pow(x, 2.0);
        C = Math.pow(5.0, 2.0);

        // Math.abs é o valor absoluto.
        // Exemplo: A = Math.abs(x); A vai receber o valor absoluto de x.

        A = Math.abs(y);
        B = Math.abs(z);

        // ========================
        // Variáveis Condicionais
        // ========================

        // Variável " Se " (que no caso é if), utilizamos " { " para fazer uma condição.

        // Valor para exemplo
        int X1 = 5;
        // Variável
        if (X1 > 0) {
            // Comando;
        }

        // Else (Estrutura condicional composta)
        if (X1 > 0) {
            // Comando 1;
        }
        else {
            // Comando 2;
        }


    }
}
