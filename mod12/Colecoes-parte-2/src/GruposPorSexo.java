import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GruposPorSexo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> masculinos = new ArrayList<>();
        List<String> femininos = new ArrayList<>();

        char continuar = 'S';

        do {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o sexo (M para masculino, F para feminino): ");
            String sexo = scanner.nextLine().trim().toUpperCase();

            if (sexo.equals("M")) {
                masculinos.add(nome);
            } else if (sexo.equals("F")) {
                femininos.add(nome);
            } else {
                System.out.println("Sexo inválido! Tente novamente.");
                continue;
            }

            System.out.print("Deseja cadastrar outra pessoa? (S/N): ");
            continuar = scanner.nextLine().trim().toUpperCase().charAt(0);
        } while (continuar == 'S');

        System.out.println("\nGrupo Masculino:");
        for (String nome : masculinos) {
            System.out.println(nome);
        }

        System.out.println("\nGrupo Feminino:");
        for (String nome : femininos) {
            System.out.println(nome);
        }

        scanner.close();
    }
}
