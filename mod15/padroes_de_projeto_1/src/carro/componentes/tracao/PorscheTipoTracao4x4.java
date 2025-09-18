package carro.componentes.tracao;

public class PorscheTipoTracao4x4 implements ITipoTracao {
  @Override
  public void descreverTracao() {
    System.out.println("Tração integral 4x4 Porsche.");
  }

  @Override
  public String tipo() {
    return "Integral 4x4";
  }
}
