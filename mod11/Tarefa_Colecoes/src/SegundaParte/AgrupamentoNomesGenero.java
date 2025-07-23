package SegundaParte;
import java.util.*;

public class AgrupamentoNomesGenero {
    private Map<String, List<String>> grupos;

    public AgrupamentoNomesGenero() {
        grupos = new HashMap<>();
        grupos.put("F", new ArrayList<>());
        grupos.put("M", new ArrayList<>());
    }

    public void adicionar(String entrada) {
        String[] partes = entrada.split("-");

        if (partes.length == 2) {
            String nome = partes[0].trim();
            String genero = partes[1].trim().toUpperCase();

            if (genero.equals("F") || genero.equals("M")) {
                grupos.get(genero).add(nome);
            } else {
                System.out.println("⚠️ Gênero inválido. Use F ou M.");
            }
        }  else {
            System.out.println("⚠️ Entrada inválida. Use o formato: Nome - F ou Nome - M");
        }
    }

    public void imprimirGruposOrdenados() {
        System.out.println("\n--- Feminino ---");
        List<String> mulheres = grupos.get("F");
        Collections.sort(mulheres);
        for (String nome : mulheres) {
            System.out.println(nome);
        }

        System.out.println("\n--- Masculino ---");
        List<String> homens = grupos.get("M");
        Collections.sort(homens);
        for (String nome : homens) {
            System.out.println(nome);
        }
    }
}
