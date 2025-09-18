package carro.componentes.rodas;

public class BYDRoda17Aco implements IRodas {
  @Override
  public void tipoRoda() {
    System.out.println("Rodas liga leve BYD aro 17.");
  }

  @Override
  public int tamanhoAro() {
    return 17;
  }
}
