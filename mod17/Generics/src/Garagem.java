import java.util.ArrayList;
import java.util.List;
import carros.Carro;

public class Garagem<T extends Carro> {
  private List<T> carros = new ArrayList<>();

  public void adicionarCarro(T carro) {
    carros.add(carro);
  }

  public void listarCarros() {
    for (T carro : carros) {
      System.out.println("");
      System.out.println(carro.getModelo() + " - " + carro.getCor());
      carro.acelerar();
    }
  }
}
