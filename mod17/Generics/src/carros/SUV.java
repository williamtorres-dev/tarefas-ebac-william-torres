package carros;

public class SUV extends Carro {
  public SUV(String modelo, String cor) {
    super(modelo, cor);
  }

  @Override
  public void acelerar() {
    System.out.println("SUV acelerando!");
  }
}
