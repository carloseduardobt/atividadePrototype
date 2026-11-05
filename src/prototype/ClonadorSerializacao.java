package prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Alternativa didática de cópia profunda usando serialização. */
public final class ClonadorSerializacao {
    private ClonadorSerializacao() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clonar(T objeto) {
        if (objeto == null) {
            throw new IllegalArgumentException("O objeto a ser clonado não pode ser nulo.");
        }

        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            try (ObjectOutputStream saida = new ObjectOutputStream(buffer)) {
                saida.writeObject(objeto);
            }

            try (ObjectInputStream entrada = new ObjectInputStream(
                    new ByteArrayInputStream(buffer.toByteArray()))) {
                return (T) entrada.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("Não foi possível clonar o objeto por serialização.", e);
        }
    }
}
