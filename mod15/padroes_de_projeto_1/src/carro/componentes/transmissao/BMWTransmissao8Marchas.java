package carro.componentes.transmissao;

public class BMWTransmissao8Marchas implements ITransmissao {
  @Override
  public void mudarMarcha(int marcha) {
    System.out.println("BMW: Mudando para marcha " + marcha);
  }

  @Override
  public String tipo() {
    return "Automática 8 Marchas";
  }
}
