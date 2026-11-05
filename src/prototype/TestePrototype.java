package prototype;

/** Verificação simples da cópia profunda, sem bibliotecas externas de teste. */
public final class TestePrototype {
    private TestePrototype() {
    }

    public static void verificarCopiaProfunda(CatalogoDeInimigos catalogo) {
        Inimigo copiaAlterada = catalogo.criar("orc");
        Inimigo copiaControle = catalogo.criar("orc");

        String habilidadeOriginal = copiaControle.getHabilidades().get(0).getNome();
        copiaAlterada.getHabilidades().get(0).setNome("Habilidade modificada na cópia");

        if (habilidadeOriginal.equals(copiaAlterada.getHabilidades().get(0).getNome())) {
            throw new AssertionError("A habilidade da cópia não foi alterada como esperado.");
        }

        if (!habilidadeOriginal.equals(copiaControle.getHabilidades().get(0).getNome())) {
            throw new AssertionError("Falha: a alteração afetou outra cópia/protótipo.");
        }

        System.out.println("[OK] Cópia profunda: alterar uma habilidade não afetou o protótipo.");
        System.out.println("     Cópia alterada: " + copiaAlterada.getHabilidades().get(0));
        System.out.println("     Outra cópia:    " + copiaControle.getHabilidades().get(0));
    }
}
