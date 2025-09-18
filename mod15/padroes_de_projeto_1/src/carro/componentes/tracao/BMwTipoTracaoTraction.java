package carro.componentes.tracao;

public class BMwTipoTracaoTraction implements ITipoTracao {
  @Override
  public void descreverTracao() {
    System.out.println("Tração traseira BMW.");
  }

  @Override
  public String tipo() {
    return "Traseira";
  }
}
