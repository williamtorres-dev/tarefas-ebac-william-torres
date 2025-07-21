package br.com.escola;

import br.com.escola.notas.MediaNotas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal que inicia a aplicação.
 */
public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("=== CALCULADORA DE MÉDIA ===");

            int quantidade = obterQuantidadeNotas(scanner);

            MediaNotas mediaNotas = new MediaNotas(scanner);
            mediaNotas.lerNotas(quantidade);
            mediaNotas.imprimirMedia();

        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado.");
            e.printStackTrace();
        }
    }

    /**
     * Pede que o usuário informe a quantidade de notas e valida a entrada.
     *
     * @param scanner Scanner de entrada padrão
     * @return quantidade de notas a ser lida (>= 1)
     */
    private static int obterQuantidadeNotas(Scanner scanner) {
        int qtd = 0;
        while (qtd <= 0) {
            System.out.print("Informe a quantidade de notas: ");
            try {
                qtd = scanner.nextInt();
                if (qtd <= 0) {
                    System.out.println("A quantidade deve ser maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next(); // descarta a entrada inválida
            }
        }
        return qtd;
    }
}
