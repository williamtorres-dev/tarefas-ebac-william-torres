import PrimeiraParte.OrdenacaoAlfabeticaNomes;
import SegundaParte.AgrupamentoNomesGenero;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrdenacaoAlfabeticaNomes ordenacao = new OrdenacaoAlfabeticaNomes();
        AgrupamentoNomesGenero agrupador = new AgrupamentoNomesGenero();

        System.out.print("Digite os nomes separados por vírgula: ");
        String entrada = scanner.nextLine();

        List<String> nomesOrdenados = ordenacao.ordenar(entrada);

        System.out.println("\nNomes em ordem alfabética:");
        for (String nome : nomesOrdenados) {
            System.out.println(nome);
        }

        while (true) {
            System.out.print("Digite um nome e gênero separados por um traço (ex: Rodrigo - M) ou 'sair' para encerrar: ");
            String entradaGenero = scanner.nextLine();

            if (entradaGenero.equalsIgnoreCase("sair")) {
                break;
            }

            agrupador.adicionar(entradaGenero);
        }

        agrupador.imprimirGruposOrdenados();
        scanner.close();
    }
}
