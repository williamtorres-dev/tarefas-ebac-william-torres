import annotations.Tabela;
import model.Cliente;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("");
        Cliente cliente = new Cliente(1, "João Silva");
        System.out.println(cliente);
        System.out.println("");

        Class<?> clazz = cliente.getClass();

        if (clazz.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = clazz.getAnnotation(Tabela.class);
            System.out.println("Nome da tabela: " + tabela.value());
            System.out.println("Schema: " + tabela.schema());
            System.out.println("Catálogo: " + tabela.catalog());
            System.out.println("Descrição: " + tabela.descricao());
        } else {
            System.out.println("Annotation @Tabela não presente.");
        }
    }
}