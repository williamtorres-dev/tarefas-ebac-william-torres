import java.util.Scanner;

// Classe MediaNotas
public class MediaNotas {
    private Scanner scanner;
    private double[] notas = new double[4];

    public MediaNotas(Scanner scanner) {
        this.scanner = scanner;
    }

    public void lerNotas() {
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            String entrada = scanner.next().replace(",", ".");
            try {
                notas[i] = Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite a nota novamente.");
                i--; // volta a perguntar a mesma nota
            }
        }
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / 4;
    }

    public void imprimirMedia(double media) {
        System.out.println("A média é: " + media);
    }
}
