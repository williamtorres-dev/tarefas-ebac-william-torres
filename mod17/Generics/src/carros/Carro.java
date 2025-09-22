package carros;

public abstract class Carro {
  private String modelo;
  private String cor;

  public Carro(String modelo, String cor) {
    this.modelo = modelo;
    this.cor = cor;
  }

  public abstract void acelerar();

  public String getModelo() {
    return modelo;
  }

  public String getCor() {
    return cor;
  }
}
