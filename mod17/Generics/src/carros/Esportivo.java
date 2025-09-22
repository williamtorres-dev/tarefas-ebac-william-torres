package carros;

public class Esportivo extends Carro {
  public Esportivo(String modelo, String cor) {
    super(modelo, cor);
  }

  @Override
  public void acelerar() {
    System.out.println("Esportivo acelerando!");
  }
}
