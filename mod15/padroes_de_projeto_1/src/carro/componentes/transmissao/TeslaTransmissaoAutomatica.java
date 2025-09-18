package carro.componentes.transmissao;

public class TeslaTransmissaoAutomatica implements ITransmissao {
  @Override
  public void mudarMarcha(int marcha) {
    System.out.println("Tesla: Mudando para marcha " + marcha);
  }

  @Override
  public String tipo() {
    return "Automática Elétrica";
  }
}
