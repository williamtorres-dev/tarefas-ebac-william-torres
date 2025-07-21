package br.com.escola.notas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Classe que gerencia a leitura das notas de um aluno e o cálculo da média aritmética.
 * Aceita notas usando ponto ou vírgula como separador decimal.
 */
public class MediaNotas {

    private final Scanner scanner;
    private final List<Double> notas = new ArrayList<>();
    private double mediaIncremental = 0.0;

    /**
     * Construtor da classe.
     *
     * @param scanner um Scanner válido para entrada de dados
     */
    public MediaNotas(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    /**
     * Lê a quantidade especificada de notas do usuário.
     *
     * @param quantidade número de notas a serem lidas
     */
    public void lerNotas(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de notas deve ser maior que zero.");
        }

        for (int i = 1; i <= quantidade; i++) {
            double nota = lerNotaValida(i);
            notas.add(nota);
            mediaIncremental += (nota - mediaIncremental) / notas.size();
        }
    }

    /**
     * Imprime a média final.
     */
    public void imprimirMedia() {
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota foi informada.");
            return;
        }
        System.out.printf("%nA média das notas é: %.2f%n", mediaIncremental);
    }

    /**
     * Lê uma única nota do usuário, tratando exceções e permitindo vírgula ou ponto.
     *
     * @param indice número da nota (para exibição ao usuário)
     * @return valor da nota
     */
    private double lerNotaValida(int indice) {
        while (true) {
            System.out.print("Digite a nota " + indice + " (0 a 10): ");
            String entrada = scanner.next().replace(',', '.'); // Convertendo vírgula para ponto

            try {
                double valor = Double.parseDouble(entrada);
                if (valor >= 0 && valor <= 10) {
                    return valor;
                } else {
                    System.out.println("Erro: a nota deve estar entre 0 e 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: entrada inválida. Digite um número válido.");
            }
        }
    }
}
