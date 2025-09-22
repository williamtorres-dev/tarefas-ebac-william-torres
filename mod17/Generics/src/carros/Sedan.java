package carros;

public class Sedan extends Carro {
  public Sedan(String modelo, String cor) {
    super(modelo, cor);
  }

  @Override
  public void acelerar() {
    System.out.println("Sedan acelerando!");
  }
}
