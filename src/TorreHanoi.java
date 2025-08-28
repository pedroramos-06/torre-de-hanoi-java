import java.util.Random;

public class TorreHanoi {
    int[][] tabuleiro;
    int[] indiceTorres;

    public TorreHanoi(){
        this.tabuleiro = new int[3][9];
        this.indiceTorres = new int[3];
    }

    void criarJogo(){
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
            System.err.println();
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

}
