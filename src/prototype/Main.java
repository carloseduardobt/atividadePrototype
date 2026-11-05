package prototype;

import java.util.ArrayList;
import java.util.List;

/** Client: usa o catálogo sem precisar conhecer a lógica interna de clonagem. */
public class Main {
    public static void main(String[] args) {
        CatalogoDeInimigos catalogo = criarCatalogo();

        System.out.println("=== TESTE DE CÓPIA PROFUNDA ===");
        TestePrototype.verificarCopiaProfunda(catalogo);

        System.out.println();
        System.out.println("=== SPAWN DE 100 INIMIGOS ===");
        List<Inimigo> inimigos = gerarInimigos(catalogo, 100);
        System.out.println("Total de inimigos gerados: " + inimigos.size());
        System.out.println("Primeiros 5 inimigos:");
        for (int i = 0; i < 5; i++) {
            System.out.println(inimigos.get(i));
        }
        System.out.println("Último inimigo:");
        System.out.println(inimigos.get(inimigos.size() - 1));

        // Altera um inimigo já criado e mostra que os demais não são afetados.
        inimigos.get(0).setVida(1);
        System.out.println();
        System.out.println("Vida do primeiro inimigo após alteração: " + inimigos.get(0).getVida());
        System.out.println("Vida do segundo inimigo (inalterada): " + inimigos.get(1).getVida());

        System.out.println();
        System.out.println("Para executar a comparação avançada, rode: java -cp out prototype.BenchmarkPrototype");
    }

    private static CatalogoDeInimigos criarCatalogo() {
        CatalogoDeInimigos catalogo = new CatalogoDeInimigos();

        Inimigo orc = new Inimigo("Orc", 120, 1.2);
        orc.adicionarHabilidade(new Habilidade("Machadada", 25));
        orc.adicionarHabilidade(new Habilidade("Rugido", 0));
        catalogo.registrar("orc", orc);

        Inimigo esqueleto = new Inimigo("Esqueleto", 80, 1.8);
        esqueleto.adicionarHabilidade(new Habilidade("Flecha", 18));
        esqueleto.adicionarHabilidade(new Habilidade("Ataque ósseo", 12));
        catalogo.registrar("esqueleto", esqueleto);

        Inimigo dragao = new Inimigo("Dragão", 500, 0.8);
        dragao.adicionarHabilidade(new Habilidade("Bola de fogo", 70));
        dragao.adicionarHabilidade(new Habilidade("Sopro de fogo", 100));
        catalogo.registrar("dragao", dragao);

        return catalogo;
    }

    private static List<Inimigo> gerarInimigos(CatalogoDeInimigos catalogo, int quantidade) {
        String[] tipos = { "orc", "esqueleto", "dragao" };
        List<Inimigo> inimigos = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            String tipo = tipos[i % tipos.length];
            Inimigo novoInimigo = catalogo.criar(tipo);

            // Cada instância recebe coordenadas próprias no mapa.
            novoInimigo.setPosicao(i * 3, i * 2);
            inimigos.add(novoInimigo);
        }

        return inimigos;
    }
}
