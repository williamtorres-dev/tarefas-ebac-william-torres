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
            notas[i] = scanner.nextDouble();
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
