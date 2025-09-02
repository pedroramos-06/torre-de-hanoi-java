public class Principal {
    public static void main(String[] args) throws Exception {
        TorreHanoi jogo = new TorreHanoi();

        jogo.criarJogo();

        do{
            jogo.imprimirJogo();

            jogo.verificarComando();
        }while(!jogo.verificarVitoria());
        
    }
}
