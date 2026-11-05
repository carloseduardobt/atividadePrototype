package prototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** ConcretePrototype: inimigo pré-configurado que pode ser clonado. */
public class Inimigo implements Prototype<Inimigo>, Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int vida;
    private double velocidade;
    private List<Habilidade> habilidades;
    private int posicaoX;
    private int posicaoY;

    public Inimigo(String nome, int vida, double velocidade) {
        this.nome = nome;
        this.vida = vida;
        this.velocidade = velocidade;
        this.habilidades = new ArrayList<>();
    }

    /** Construtor de cópia com cópia profunda da lista de habilidades. */
    public Inimigo(Inimigo origem) {
        this.nome = origem.nome;
        this.vida = origem.vida;
        this.velocidade = origem.velocidade;
        this.posicaoX = origem.posicaoX;
        this.posicaoY = origem.posicaoY;
        this.habilidades = new ArrayList<>();

        for (Habilidade habilidade : origem.habilidades) {
            this.habilidades.add(new Habilidade(habilidade));
        }
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        habilidades.add(new Habilidade(habilidade));
    }

    @Override
    public Inimigo clonar() {
        return new Inimigo(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicao(int x, int y) {
        this.posicaoX = x;
        this.posicaoY = y;
    }

    @Override
    public String toString() {
        return nome
                + " | vida: " + vida
                + " | velocidade: " + velocidade
                + " | posição: (" + posicaoX + ", " + posicaoY + ")"
                + " | habilidades: " + habilidades;
    }
}
