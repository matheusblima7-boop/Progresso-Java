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

        // Para printar algo formatado, usamos System.out.printf (no caso, ao invés do println usamos printf)
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

        // Com printf (formatado) "TEXTO1 %f TEXTO2 %f TEXTO3", <variável 1>, <variável 2>
        // %f = ponto flutuante (para colocar variáveis double) %n = quebra de linha
        // %s = texto (para texto, variáveis Strings) %d = inteiro (variável int, números inteiros)
        // %c = variáveis char (de um unico caractere)

        System.out.printf("RESULTADO =  %.2f METROS%n" ,exemplo);
        System.out.printf("%s tem %d anos e ganha %.2f reais%n",nome,idade,exemplo);

        Scanner sc = new Scanner(System.in);

        Locale.setDefault(Locale.getDefault());

        // ==========================================================================
        // Input em Java
        // ==========================================================================

        // A gente sempre cria a variável primeiro, pra depois declarar que ela é um Input. Exemplo: String x --> x = sc.next(); (Input)
        // Sempre colocamos o tipo de variável após o "next". Exemplo: variável int: sc.nextInt


        // Input sendo string

        System.out.println("Exemplo Input 1");
        String x;
        x = sc.next();
        System.out.println("Você digitou: " + x);

        // Input sendo número inteiro

        System.out.println("Exemplo Input 2");
        int y;
        y = sc.nextInt();
        System.out.println("Você digitou: " + y);

        // Input sendo Double
        // Obs: Quando for usar o "println" e o medidor decimal estiver no padrão dos USA, você deve digitar o número double com "." ao invés da vírgula.
        // E vice-versa; para o código funcionar.

        System.out.println("Exemplo Input 3");
        double z;
        z = sc.nextDouble();
        System.out.println("Você digitou: " + z);
        // Mas para evitar isso, você pode usar o "printf" para ele usar o medidor decimal do jeito que você quer.
        System.out.printf("%.2f%n", z);

        // Input sendo char (pra ler um caractere apenas)
        // Usamos o "sc.next()" para ler a string (texto), e após isso escrevemos ".charAt(0);"
        // o "sc.next()" lê o texto, e o ".charAt(0)" pega o primeiro caractere do texto/palavra que você escreveu

        System.out.println("Exemplo Input 4");
        char w;
        w = sc.next().charAt(0);
        System.out.println("Você digitou: " + w);

        // Quando queremos ter varios inputs na mesma linha (ler vários dados na mesma linha)
        // Colocamos as variaveis, colocamos .sc e o tipo de variavel, e depois é só printar tudo.
        // Exemplo:

        System.out.println("Exemplo Input 5");
        String a;
        int b;
        double c;

        a = sc.next();
        b = sc.nextInt();
        c = sc.nextDouble();

        System.out.printf("Dados digitados: %n");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        // Quebra de linha pendente
        // As vezes uma quebra de linha vazia pode acontecer no terminal quando há vários ‘inputs’ sendo printados;
        // Para resolver isso, escrevemos um sc.nextLine vazio na onde está a ocorrer a quebra de linha, para ele absover essa quebra.

        System.out.println("Exemplo Input 6");
        int s1;
        String s2, s3, s4;


        s1 = sc.nextInt();
        sc.nextLine();
        s2 = sc.nextLine();
        s3 = sc.nextLine();
        s4 = sc.nextLine();

        System.out.println("DADOS PROCESSADOS:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);


        // ==========================================================================
        // Matemática em Java
        // ==========================================================================

        // Valores definidos
        double m1 = 3.0;
        double m2 = 4.0;
        double m3 = -5.0;

        // Variáveis que vão receber o resultado da conta
        double A, B, C;



        // Math.sqrt(variável do valor) faz raiz quadrada. Exemplo: A = Math.sqrt(x);
        // A variável "A" vai receber o valor da raiz quadrada de "x"
        A = Math.sqrt(m1);
        B = Math.sqrt(m2);
        C = Math.sqrt(25.0);
        System.out.println("Raiz quadrada de: " +  m1 + " é igual a: " + A);
        System.out.println("Raiz quadrada de: " + m2 + " é igual a: " + B);
        System.out.println("Raiz quadrada de 25 é igual a : " + C);

        // Math.pow é potência. Se digitarmos Math.pow(x, y), a conta vai ser x elevado a y.
        // Também podemos escrever números ao invés de variáveis
        A = Math.pow(m1, m2);
        B = Math.pow(m1, 2.0);
        C = Math.pow(5.0, 2.0);
        System.out.println(m1 + "elevado a : " + m2 + " é igual a " + A);
        System.out.println("Raiz quadrada de " + m2 + " é igual a " + B);
        System.out.println("Raiz quadrada de 25 = " + C);

        // Math.abs é o valor absoluto.
        // Exemplo: A = Math.abs(x); A vai receber o valor absoluto de x.
        A = Math.abs(m1);
        B = Math.abs(m3);
        System.out.println("Valor absoluto de " + m2 + " é igual a" + A);
        System.out.println("Valor absoluto de " + m3 + " é igual a" + B);

        // =================================================================
        // Estrutura condicional (If, else, boolean, etc.)
        // =================================================================

        // Operadores comparativos:
        // " > ": Maior      " < ": Menor    " > = ": Maior ou igual
        // " < = ": Menor ou igual   " == ": Igual   " ! = " Diferente


        // ===========================================
        // Estrutura condicional simples
        // ===========================================

        // Variável " Se " (que no caso é if), utilizamos " { " para fazer uma condição.

        // X1 será nosso valor.
        int X1 = 5;

        // Essa é a nossa condição.
        if (X1 > 0) { // Condição
            System.out.println("X é maior que zero"); // Ação
        }

        // Se escrevêssemos " X1 < 0 ", a mensagem não iria aparecer.

        // ===========================================
        // Estrutura condicional composta (if + else)
        // ===========================================

        if (X1 < 0) {
            System.out.println("Errado.");
        } //Primeiro comando
        else {
            System.out.println("Certo.");
        }

        // Exemplo com input
        int hora;

        System.out.println("Que horas são?");
        hora = sc.nextInt();

        if (hora < 12) {
            System.out.println("Bom dia");
        }
        else if (hora <= 18) {
            System.out.println("Boa tarde");
        }
        else if (hora > 18) {
            System.out.println("Boa noite");
        }





    }
}
