package prototype;

import java.io.Serializable;

/** Habilidade que faz parte do estado de um inimigo. */
public class Habilidade implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int dano;

    public Habilidade(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    /** Construtor de cópia: cria outra instância com os mesmos valores. */
    public Habilidade(Habilidade origem) {
        this.nome = origem.nome;
        this.dano = origem.dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    @Override
    public String toString() {
        return nome + " (dano: " + dano + ")";
    }
}
