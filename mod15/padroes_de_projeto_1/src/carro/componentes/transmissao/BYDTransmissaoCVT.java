package carro.componentes.transmissao;

public class BYDTransmissaoCVT implements ITransmissao {
  @Override
  public void mudarMarcha(int marcha) {
    System.out.println("BYD: Mudando marcha via CVT.");
  }

  @Override
  public String tipo() {
    return "CVT Automática";
  }
}
