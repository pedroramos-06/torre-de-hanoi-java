import java.util.Random;
import java.util.Scanner;

public class TorreHanoi {
    int[][] tabuleiro;
    int[] indiceTorres;

    public TorreHanoi(){
        this.tabuleiro = new int[3][9];
        this.indiceTorres = new int[3];
    }

    void criarJogo(){
        for(int i = 0; i<9; i++){
            this.tabuleiro[0][i] = 9-i;
        }

        this.indiceTorres[0] = 9;
    }

    void criarJogoAleatorio(){
        Random numero = new Random();

        this.indiceTorres = new int[3];

        for(int i=9; i>=1; i--){
            int naleatorio = numero.nextInt(3);

            this.tabuleiro[naleatorio][this.indiceTorres[naleatorio]++] = i;
        }
    }

    void imprimirJogo(){
        for(int i=8; i>=0; i--){
            for(int j=0; j<3; j++){
                imprimirbloco(this.tabuleiro[j][i]);
            }
            System.out.println();
        }
    }

    void imprimirbloco(int n){
        switch (n) {
            case 1 -> System.out.print("        [1]        ");
            case 2 -> System.out.print("       [[2]]       ");
            case 3 -> System.out.print("      [[[3]]]      ");
            case 4 -> System.out.print("     [[[[4]]]]     ");
            case 5 -> System.out.print("    [[[[[5]]]]]    ");
            case 6 -> System.out.print("   [[[[[[6]]]]]]   ");
            case 7 -> System.out.print("  [[[[[[[7]]]]]]]  ");
            case 8 -> System.out.print(" [[[[[[[[8]]]]]]]] ");
            case 9 -> System.out.print("[[[[[[[[[9]]]]]]]]]");
            default -> System.out.print("         |         ");
        }
    }

    void imprimirindices(){
        System.out.println(indiceTorres[0]);
        System.out.println(indiceTorres[1]);
        System.out.println(indiceTorres[2]);
    }

    int obterTorreInicial(Scanner entrada){
        int torreInicial;

        while(true){
            System.out.print("Digite o numero da torre(1-3): ");
            torreInicial = entrada.nextInt();
            
            if(torreInicial < 1 || torreInicial > 3){
                System.out.println("Numero invalido! fora dos limites");
                continue;

            } else if(indiceTorres[torreInicial-1] == 0){
                System.out.println("Jogada invalida! Torre não possui elementos");
                continue;
            }

            return torreInicial-1;
        }
    }

    int obterTorreDestino(Scanner entrada){
        int torreDestino;

        while(true){
            System.out.print("Digite para que torre quer mover a peça: ");
            torreDestino = entrada.nextInt();

            if(torreDestino < 1 || torreDestino > 3){
                System.out.println("Numero invalido! fora dos limites");
                continue;

            }

            return torreDestino-1;
        }
    }
    void verificarComando(){
        Scanner entrada = new Scanner(System.in);
        int torreInicial, torreDestino;

        do {
            System.out.print("Digite o numero da torre(1-3): ");
            torreInicial = entrada.nextInt();

            if(torreInicial < 1 || torreInicial > 3){
                System.out.println("Numero invalido! fora dos limites");

            } else if(indiceTorres[torreInicial-1] == 0){
                System.out.println("Jogada invalida! Torre não possui elementos");
            }

        } while ((torreInicial < 1 || torreInicial > 3) || indiceTorres[torreInicial-1] == 0);


        do {
            System.out.print("Digite para que torre quer mover a peça: ");
            torreDestino = entrada.nextInt();

            if(torreDestino < 1 || torreDestino > 3){
                System.out.println("Numero invalido! fora dos limites");

            } else if(indiceTorres[torreDestino-1] == 0){
                break;
                
            } else if(tabuleiro[torreInicial-1][indiceTorres[torreInicial-1]-1] > tabuleiro[torreDestino-1][indiceTorres[torreDestino-1]-1]){
                System.out.println("Jogada invalida! peça da torre de destino é menor");
            }

        } while ((torreDestino < 1 || torreDestino > 3) || (tabuleiro[torreInicial-1][indiceTorres[torreInicial-1]-1] > tabuleiro[torreDestino-1][indiceTorres[torreDestino-1]-1]));

        executarJogada(torreInicial-1, torreDestino-1);
    }

    void executarJogada(int torreInicial, int torreDestino){
        if(torreInicial == torreDestino){
            return;
        }

        tabuleiro[torreDestino][indiceTorres[torreDestino]] = tabuleiro[torreInicial][indiceTorres[torreInicial]-1];
        tabuleiro[torreInicial][indiceTorres[torreInicial]-1] = 0;

        indiceTorres[torreDestino]++;
        indiceTorres[torreInicial]--;
    }

    boolean verificarVitoria(){
        return this.tabuleiro[1][8] == 1 || this.tabuleiro[2][8] == 1;
    }
}
