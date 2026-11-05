package prototype;

/** Contrato comum para objetos que sabem produzir uma cópia de si mesmos. */
public interface Prototype<T> {
    T clonar();
}
