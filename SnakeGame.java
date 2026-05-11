import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class SnakeGame extends JPanel {

    // =========================
    // CONFIGURAÇÕES
    // =========================

    private static final int LARGURA_TELA = 800;
    private static final int ALTURA_TELA = 600;

    private static final int TAMANHO_BLOCO = 25;

    private static final int COLUNAS =
            LARGURA_TELA / TAMANHO_BLOCO;

    private static final int LINHAS =
            ALTURA_TELA / TAMANHO_BLOCO;

    private static final int FPS = 12;

    // =========================
    // FONTES
    // =========================

    private static final Font HUD_FONT =
            new Font("Arial", Font.BOLD, 28);

    private static final Font GAME_OVER_FONT =
            new Font("Arial", Font.BOLD, 55);

    // =========================
    // ESTADOS
    // =========================

    private enum Estado {

        MENU,
        JOGANDO,
        PAUSADO,
        GAME_OVER,
        VITORIA
    }

    private Estado estado =
            Estado.JOGANDO;

    // =========================
    // DIREÇÃO
    // =========================

    private enum Direcao {

        CIMA,
        BAIXO,
        ESQUERDA,
        DIREITA
    }

    private Direcao direcao =
            Direcao.DIREITA;

    // =========================
    // SEGMENTO
    // =========================

    private static class Segmento {

        int x;
        int y;

        Segmento(int x, int y) {

            this.x = x;
            this.y = y;
        }
    }

    // =========================
    // COBRA
    // =========================

    private final LinkedList<Segmento> cobra =
            new LinkedList<>();

    // Otimiza colisão
    private final Set<String> posicoes =
            new HashSet<>();

    // =========================
    // COMIDA
    // =========================

    private int comidaX;
    private int comidaY;

    // =========================
    // SISTEMA
    // =========================

    private Timer timer;

    private final Random random =
            new Random();

    private boolean mudouDirecao =
            false;

    private boolean crescer =
            false;

    private int pontos =
            0;

    // =========================
    // CONSTRUTOR
    // =========================

    public SnakeGame() {

        setPreferredSize(
                new Dimension(
                        LARGURA_TELA,
                        ALTURA_TELA
                )
        );

        setBackground(Color.BLACK);

        setFocusable(true);

        configurarControles();

        iniciarJogo();

        iniciarLoop();
    }

    // =========================
    // LOOP
    // =========================

    private void iniciarLoop() {

        int delay = 1000 / FPS;

        timer = new Timer(
                delay,
                this::update
        );

        timer.start();
    }

    // =========================
    // INICIAR
    // =========================

    private void iniciarJogo() {

        cobra.clear();

        posicoes.clear();

        pontos = 0;

        direcao = Direcao.DIREITA;

        estado = Estado.JOGANDO;

        adicionarSegmento(5, 5);
        adicionarSegmento(4, 5);
        adicionarSegmento(3, 5);

        gerarComida();
    }

    // =========================
    // SEGMENTOS
    // =========================

    private void adicionarSegmento(
            int gridX,
            int gridY
    ) {

        int x = gridX * TAMANHO_BLOCO;
        int y = gridY * TAMANHO_BLOCO;

        cobra.add(
                new Segmento(x, y)
        );

        posicoes.add(chave(x, y));
    }

    // =========================
    // UPDATE
    // =========================

    private void update(ActionEvent e) {

        if (estado != Estado.JOGANDO) {

            repaint();
            return;
        }

        mudouDirecao = false;

        mover();

        verificarComida();

        verificarColisoes();

        repaint();
    }

    // =========================
    // MOVIMENTO
    // =========================

    private void mover() {

        Segmento cabeca =
                cobra.getFirst();

        int novoX = cabeca.x;
        int novoY = cabeca.y;

        switch (direcao) {

            case CIMA:










                novoY -= TAMANHO_BLOCO;
                break;

            case BAIXO:
                novoY += TAMANHO_BLOCO;
                break;

            case ESQUERDA:
                novoX -= TAMANHO_BLOCO;
                break;

            case DIREITA:
                novoX += TAMANHO_BLOCO;
                break;
        }

        Segmento novaCabeca =
                new Segmento(novoX, novoY);

        cobra.addFirst(novaCabeca);

        posicoes.add(chave(novoX, novoY));

        if (!crescer) {

            Segmento cauda =
                    cobra.removeLast();

            posicoes.remove(
                    chave(cauda.x, cauda.y)
            );

        } else {

            crescer = false;
        }
    }

    // =========================
    // COMIDA
    // =========================

    private void gerarComida() {

        do {

            comidaX =
                    random.nextInt(COLUNAS)
                            * TAMANHO_BLOCO;

            comidaY =
                    random.nextInt(LINHAS)
                            * TAMANHO_BLOCO;

        } while (
                posicoes.contains(
                        chave(comidaX, comidaY)
                )
        );
    }

    // =========================
    // COMER
    // =========================

    private void verificarComida() {

        Segmento cabeca =
                cobra.getFirst();

        if (cabeca.x == comidaX &&
                cabeca.y == comidaY) {

            crescer = true;

            pontos++;

            gerarComida();

            aumentarVelocidade();

            if (cobra.size() ==
                    COLUNAS * LINHAS) {

                estado = Estado.VITORIA;
            }
        }
    }

    // =========================
    // VELOCIDADE
    // =========================

    private void aumentarVelocidade() {

        int novoDelay =
                Math.max(
                        45,
                        timer.getDelay() - 1
                );

        timer.setDelay(novoDelay);
    }

    // =========================
    // COLISÕES
    // =========================

    private void verificarColisoes() {

        Segmento cabeca =
                cobra.getFirst();

        // Parede
        if (cabeca.x < 0 ||
                cabeca.x >= LARGURA_TELA ||
                cabeca.y < 0 ||
                cabeca.y >= ALTURA_TELA) {

            estado = Estado.GAME_OVER;
        }

        // Corpo
        for (int i = 1;
             i < cobra.size();
             i++) {

            Segmento s =
                    cobra.get(i);

            if (cabeca.x == s.x &&
                    cabeca.y == s.y) {

                estado = Estado.GAME_OVER;
                break;
            }
        }
    }

    // =========================
    // CONTROLES
    // =========================

    private void configurarControles() {

        InputMap input =
                getInputMap(
                        WHEN_IN_FOCUSED_WINDOW
                );

        ActionMap actions =
                getActionMap();

        registrarTecla(
                input,
                actions,
                "LEFT",
                "esquerda",
                Direcao.ESQUERDA,
                Direcao.DIREITA
        );

        registrarTecla(
                input,
                actions,
                "RIGHT",
                "direita",
                Direcao.DIREITA,
                Direcao.ESQUERDA
        );

        registrarTecla(
                input,
                actions,
                "UP",
                "cima",
                Direcao.CIMA,
                Direcao.BAIXO
        );

        registrarTecla(
                input,
                actions,
                "DOWN",
                "baixo",
                Direcao.BAIXO,
                Direcao.CIMA
        );

        // Restart
        input.put(
                KeyStroke.getKeyStroke("ENTER"),
                "restart"
        );

        actions.put(
                "restart",
                new AbstractAction() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        if (estado ==
                                Estado.GAME_OVER ||
                                estado ==
                                        Estado.VITORIA) {

                            iniciarJogo();
                        }
                    }
                }
        );

        // Pause
        input.put(
                KeyStroke.getKeyStroke("ESCAPE"),
                "pause"
        );

        actions.put(
                "pause",
                new AbstractAction() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        if (estado ==
                                Estado.JOGANDO) {

                            estado =
                                    Estado.PAUSADO;

                        } else if (
                                estado ==
                                        Estado.PAUSADO) {

                            estado =
                                    Estado.JOGANDO;
                        }
                    }
                }
        );
    }

    // =========================
    // REGISTRAR TECLA
    // =========================

    private void registrarTecla(

            InputMap input,
            ActionMap actions,

            String tecla,
            String nome,

            Direcao novaDirecao,
            Direcao oposta
    ) {

        input.put(
                KeyStroke.getKeyStroke(tecla),
                nome
        );

        actions.put(
                nome,
                new AbstractAction() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        if (!mudouDirecao &&
                                direcao != oposta &&
                                estado ==
                                        Estado.JOGANDO) {

                            direcao =
                                    novaDirecao;

                            mudouDirecao = true;
                        }
                    }
                }
        );
    }

    // =========================
    // RENDER
    // =========================

    @Override
    protected void paintComponent(
            Graphics g
    ) {

        super.paintComponent(g);

        Graphics2D g2d =
                (Graphics2D) g;

        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        desenharGrid(g2d);

        desenharComida(g2d);

        desenharCobra(g2d);

        desenharHUD(g2d);

        switch (estado) {

            case GAME_OVER:
                desenharMensagem(
                        g2d,
                        "GAME OVER",
                        Color.RED
                );
                break;

            case PAUSADO:
                desenharMensagem(
                        g2d,
                        "PAUSADO",
                        Color.YELLOW
                );
                break;

            case VITORIA:
                desenharMensagem(
                        g2d,
                        "VOCÊ VENCEU!",
                        Color.GREEN
                );
                break;
        }
    }

    // =========================
    // GRID
    // =========================

    private void desenharGrid(
            Graphics2D g
    ) {

        g.setColor(
                new Color(30, 30, 30)
        );

        for (int i = 0;
             i < COLUNAS;
             i++) {

            g.drawLine(
                    i * TAMANHO_BLOCO,
                    0,
                    i * TAMANHO_BLOCO,
                    ALTURA_TELA
            );
        }

        for (int i = 0;
             i < LINHAS;
             i++) {

            g.drawLine(
                    0,
                    i * TAMANHO_BLOCO,
                    LARGURA_TELA,
                    i * TAMANHO_BLOCO
            );
        }
    }

    // =========================
    // COMIDA
    // =========================

    private void desenharComida(
            Graphics2D g
    ) {

        g.setColor(Color.RED);

        g.fillOval(
                comidaX,
                comidaY,
                TAMANHO_BLOCO,
                TAMANHO_BLOCO
        );
    }

    // =========================
    // COBRA
    // =========================

    private void desenharCobra(
            Graphics2D g
    ) {

        for (int i = 0;
             i < cobra.size();
             i++) {

            Segmento s =
                    cobra.get(i);

            if (i == 0) {

                g.setColor(
                        new Color(0, 255, 120)
                );

            } else {

                g.setColor(
                        new Color(0, 180, 70)
                );
            }

            g.fillRoundRect(
                    s.x,
                    s.y,
                    TAMANHO_BLOCO,
                    TAMANHO_BLOCO,
                    10,
                    10
            );
        }
    }

    // =========================
    // HUD
    // =========================

    private void desenharHUD(
            Graphics2D g
    ) {

        g.setColor(Color.WHITE);

        g.setFont(HUD_FONT);

        String texto =
                "Pontos: " + pontos;

        FontMetrics metrics =
                g.getFontMetrics();

        g.drawString(
                texto,
                (LARGURA_TELA -
                        metrics.stringWidth(texto)) / 2,
                35
        );
    }

    // =========================
    // MENSAGENS
    // =========================

    private void desenharMensagem(

            Graphics2D g,
            String texto,
            Color cor
    ) {

        g.setColor(cor);

        g.setFont(GAME_OVER_FONT);

        FontMetrics metrics =
                g.getFontMetrics();

        g.drawString(
                texto,
                (LARGURA_TELA -
                        metrics.stringWidth(texto)) / 2,
                ALTURA_TELA / 2
        );

        g.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        22
                )
        );

        String restart =
                "ENTER = Reiniciar | ESC = Pause";

        g.drawString(
                restart,
                (LARGURA_TELA -
                        g.getFontMetrics()
                                .stringWidth(restart)) / 2,
                ALTURA_TELA / 2 + 50
        );
    }

    // =========================
    // CHAVE HASH
    // =========================

    private String chave(
            int x,
            int y
    ) {

        return x + ":" + y;
    }

    // =========================
    // MAIN
    // =========================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame =
                    new JFrame(
                            "Snake Game"
                    );

            frame.add(
                    new SnakeGame()
            );

            frame.pack();

            frame.setResizable(false);

            frame.setLocationRelativeTo(null);

            frame.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            frame.setVisible(true);
        });
    }
}