package carro.componentes.transmissao;

public class PorscheTransmissaoAutomatic implements ITransmissao {
  @Override
  public void mudarMarcha(int marcha) {
    System.out.println("Porsche: Mudança automática realizada na marcha " + marcha);
  }

  @Override
  public String tipo() {
    return "Automática";
  }
}
