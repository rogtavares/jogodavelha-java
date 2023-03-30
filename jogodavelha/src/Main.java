import java.util.Scanner;
public class JogoDaVelmasiaha {

    private char[][] tabuleiro = new char[3][3];
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public JogoDaVelha(String nomeJogador1, String nomeJogador2) {
        jogador1 = new Jogador(nomeJogador1, 'X');
        jogador2 = new Jogador(nomeJogador2, 'O');
        jogadorAtual = jogador1;
        inicializarTabuleiro();
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        while (true) {
            System.out.println(jogadorAtual.getNome() + ", faça sua jogada (linha[1-3] coluna[1-3]): ");
            linha = scanner.nextInt() - 1;
            coluna = scanner.nextInt() - 1;

            if (validarJogada(linha, coluna)) {
                fazerJogada(linha, coluna);
                imprimirTabuleiro();

                if (jogoAcabou()) {
                    System.out.println("Fim de jogo!");
                    if (jogadorVenceu(jogadorAtual)) {
                        System.out.println(jogadorAtual.getNome() + " venceu!");
                    } else {
                        System.out.println("Empate!");
                    }
                    break;
                }

                jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
            } else {
                System.out.println("Jogada inválida, tente novamente.");
            }
        }

        scanner.close();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private void imprimirTabuleiro() {
        System.out.println("Tabuleiro:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean validarJogada(int linha
