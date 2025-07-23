package PrimeiraParte;
import java.util.*;

public class OrdenacaoAlfabeticaNomes {

    public List<String> ordenar(String entrada) {
        String[] nomesArray = entrada.split(",");
        List<String> nomes =  new ArrayList<>();

        for (String nome : nomesArray) {
            nomes.add(nome.trim());
        }

        Collections.sort(nomes);
        return nomes;
    }
}
