import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Program {
    @Tabela(value = "Class Annotations")
    private String nomeTabela;

    public static void main(String[] args) throws NoSuchFieldException {
        // Obtendo o campo da classe
        Field campo = Program.class.getDeclaredField("nomeTabela");

        // Verificando se a anotação está presente no campo
        if (campo.isAnnotationPresent(Tabela.class)) {
            // Obtendo a anotação do campo
            Tabela anotacao = campo.getAnnotation(Tabela.class);

            // Lendo o valor da anotação
            String nomeTabela = anotacao.value();

            // Imprimindo o valor da anotação
            System.out.println("Nome da Tabela: " + nomeTabela);
        } else {
            System.out.println("A anotação não está presente no campo.");
        }
    }
}