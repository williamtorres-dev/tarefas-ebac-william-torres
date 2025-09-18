package carro.componentes.rodas;

public class TeslaRoda18Eletrica implements IRodas {
  @Override
  public void tipoRoda() {
    System.out.println("Rodas aerodinâmicas de alumínio Tesla.");
  }

  @Override
  public int tamanhoAro() {
    return 18;
  }
}
