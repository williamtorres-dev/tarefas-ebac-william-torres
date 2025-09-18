package carro.componentes.rodas;

public class PorscheRoda20LigaLeve implements IRodas {
  @Override
  public void tipoRoda() {
    System.out.println("Rodas de liga leve Porsche aro 20.");
  }

  @Override
  public int tamanhoAro() {
    return 20;
  }
}
