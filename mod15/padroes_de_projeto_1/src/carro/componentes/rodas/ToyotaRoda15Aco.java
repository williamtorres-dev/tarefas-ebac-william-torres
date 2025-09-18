package carro.componentes.rodas;

public class ToyotaRoda15Aco implements IRodas {
  @Override
  public void tipoRoda() {
    System.out.println("Rodas de aço com calota Toyota.");
  }

  @Override
  public int tamanhoAro() {
    return 15;
  }
}
