package carro.componentes.tracao;

public class TeslaTipoTracaoEletrica implements ITipoTracao {
  @Override
  public void descreverTracao() {
    System.out.println("Tração integral elétrica Tesla.");
  }

  @Override
  public String tipo() {
    return "Integral Elétrica";
  }
}
