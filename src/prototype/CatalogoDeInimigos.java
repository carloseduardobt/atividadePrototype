package prototype;

import java.util.HashMap;
import java.util.Map;

/** Registry: mantém protótipos e sempre devolve uma cópia ao cliente. */
public class CatalogoDeInimigos {
    private final Map<String, Inimigo> prototipos = new HashMap<>();

    public void registrar(String chave, Inimigo prototipo) {
        if (chave == null || chave.trim().isEmpty()) {
            throw new IllegalArgumentException("A chave do protótipo não pode ser vazia.");
        }
        if (prototipo == null) {
            throw new IllegalArgumentException("O protótipo não pode ser nulo.");
        }

        // O catálogo guarda sua própria cópia para não depender do objeto recebido.
        prototipos.put(chave.toLowerCase(), prototipo.clonar());
    }

    public Inimigo criar(String chave) {
        if (chave == null) {
            throw new IllegalArgumentException("Informe a chave do inimigo.");
        }

        Inimigo prototipo = prototipos.get(chave.toLowerCase());
        if (prototipo == null) {
            throw new IllegalArgumentException("Não existe inimigo cadastrado com a chave: " + chave);
        }

        return prototipo.clonar();
    }
}
