package carro.componentes.transmissao;

public class ToyotaCVT implements ITransmissao {
  @Override
  public void mudarMarcha(int marcha) {
    System.out.println("Toyota: Transmissão CVT simulando marcha " + marcha);
  }

  @Override
  public String tipo() {
    return "CVT Automática";
  }
}
