import java.util.Scanner;

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
                i--;
            }
        }
    }

    public double calcularMedia() {
        double soma = 0;
        for(double nota: notas) {
            soma += nota;
        }
        return soma / 4;
    }

    public String statusAluno() {
        double media = calcularMedia();
        if(media >= 7) {
            return "Aluno aprovado";
        } else if (media >= 5 && media < 7) {
            return "Aluno em recuperação";
        } else {
            return "Aluno reprovado";
        }
    }

    public void imprimirSatus(double media, String status) {
        System.out.printf("A média é: %.2f\n", media);
        System.out.println(status);
    }
}
