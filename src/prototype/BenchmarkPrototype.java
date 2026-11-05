package prototype;

/** Compara o tempo de 100.000 cópias manuais e por serialização. */
public class BenchmarkPrototype {
    public static void main(String[] args) {
        Inimigo prototipo = criarDragao();
        int quantidade = 100_000;
        long checksumManual = 0;
        long checksumSerializacao = 0;

        long inicioManual = System.nanoTime();
        for (int i = 0; i < quantidade; i++) {
            Inimigo copia = prototipo.clonar();
            checksumManual += copia.getVida() + copia.getHabilidades().size();
        }
        long tempoManual = System.nanoTime() - inicioManual;

        long inicioSerializacao = System.nanoTime();
        for (int i = 0; i < quantidade; i++) {
            Inimigo copia = ClonadorSerializacao.clonar(prototipo);
            checksumSerializacao += copia.getVida() + copia.getHabilidades().size();
        }
        long tempoSerializacao = System.nanoTime() - inicioSerializacao;

        System.out.println("=== COMPARAÇÃO DE 100.000 CÓPIAS ===");
        System.out.printf("Cópia manual:       %.2f ms%n", tempoManual / 1_000_000.0);
        System.out.printf("Por serialização:   %.2f ms%n", tempoSerializacao / 1_000_000.0);
        System.out.println("Checksum manual: " + checksumManual);
        System.out.println("Checksum serialização: " + checksumSerializacao);
        System.out.println("Observação: os tempos variam conforme o computador e a JVM.");
    }

    private static Inimigo criarDragao() {
        Inimigo dragao = new Inimigo("Dragão", 500, 0.8);
        dragao.adicionarHabilidade(new Habilidade("Bola de fogo", 70));
        dragao.adicionarHabilidade(new Habilidade("Sopro de fogo", 100));
        return dragao;
    }
}
