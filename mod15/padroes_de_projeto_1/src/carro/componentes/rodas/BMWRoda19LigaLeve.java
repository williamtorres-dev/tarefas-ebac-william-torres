package carro.componentes.rodas;

public class BMWRoda19LigaLeve implements IRodas {
  @Override
  public void tipoRoda() {
    System.out.println("Rodas de liga leve BMW aro 19.");
  }

  @Override
  public int tamanhoAro() {
    return 19;
  }
}