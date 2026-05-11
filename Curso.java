import java.util.Locale;
import java.util.Scanner;
// ====================================================
// Hello World em Java
// ====================================================

public class Curso {
    public static void main(String[] args) {
        System.out.println("Olá mundo");

        // =====================================================
        // Com variáveis
        // =====================================================

        String nome = "Matheus";
        System.out.println(nome);

        int idade = 16;
        System.out.println(idade);

        double exemplo = 3.673824;
        System.out.println(exemplo);

        // Para printar algo formatado, usamos System.out.printf (no caso, ao invés do printf usamos printf)
        // Para doubles quando queremos mostrar apenas 2 ou mais casas decimais usamos ("%.2f, <double> (que no caso é "exemplo"))
        // Para cada casa decimal que você quiser mostrar, aumentar o número no ".f"
        // Se quiser uma quebra de linha, colocar ("%.2f%n, <double>

        System.out.printf("%.2f%n" ,exemplo);
        System.out.printf("%.4f%n" ,exemplo);
        System.out.printf("%.6f%n" ,exemplo);

        // Para trocar a vírgula de um double por ponto, eu tenho que configurar o computador pra usar o separador dos USA. Usamos esse comando:
        // Para usarmos esse comando precisamos importar ele para o código lá em cima.

        Locale.setDefault(Locale.US);
        System.out.printf("%.2f%n" ,exemplo);
        System.out.printf("%.4f%n" ,exemplo);
        System.out.printf("%.6f%n" ,exemplo);

        // Para juntar vários elementos em um mesmo comando de escrita
        // Elemento 1 + Elemento 2 + Elemento 3 + ... = Elemento N

        System.out.println("RESULTADO = " + exemplo + " METROS");

        // Com printf (formatado) "TEXTO1 %f TEXTO2 %f TEXTO3", <variável 1>, <variavel 2>
        // %f = ponto flutuante (para colocar variaveis double) %n = quebra de linha
        // %s = texto (para texto, variaveis Strings) %d = inteiro (variavel int, numeros inteiros)
        // %c = variaveis char (de um unico caractere)

        System.out.printf("RESULTADO =  %.2f METROS%n" ,exemplo);
        System.out.printf("%s tem %d anos e ganha %.2f reais%n",nome,idade,exemplo);

        Scanner sc = new Scanner(System.in);

        Locale.setDefault(Locale.getDefault());

        // ==========================================================================
        // Input em Java
        // ==========================================================================

        // A gente sempre cria a variavel primeiro, pra depois declarar que ela é um Input. Exemplo: String x --> x = sc.next(); (Input)
        // Sempre colocamos o tipo de variável após o "next". Exemplo: variável int: sc.nextInt


        // Input sendo string

        String x;
        x = sc.next();
        System.out.println("Você digitou: " + x);

        // Input sendo número inteiro

        int y;
        y = sc.nextInt();
        System.out.println("Você digitou: " + y);

        // Input sendo Double
        // Obs: Quando for usar o "println" e o medidor decimal estiver no padrão dos USA, você deve digitar o número double com "." ao invés da vírgula.
        // E vice-versa; para o código funcionar.

        double z;
        z = sc.nextDouble();
        System.out.println("Você digitou: " + z);
        // Mas para evitar isso, você pode usar o "printf" para ele usar o medidor decimal do jeito que você quer.
        System.out.printf("%.2f%n", z);

        // Input sendo char (pra ler um caractere apenas)
        // Usamos o "sc.next()" para ler a string (texto), e após isso escrevemos ".charAt(0);"
        // o "sc.next()" lê o texto, e o ".charAt(0)" pega o primeiro caractere do texto/palavra que você escreveu

        char w;
        w = sc.next().charAt(0);
        System.out.println("Você digitou: " + w);


        sc.close();
    }
}
