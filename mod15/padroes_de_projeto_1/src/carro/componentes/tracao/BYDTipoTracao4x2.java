package carro.componentes.tracao;

public class BYDTipoTracao4x2 implements ITipoTracao {
  @Override
  public void descreverTracao() {
    System.out.println("Tração dianteira 4x2 BYD.");
  }

  @Override
  public String tipo() {
    return "Dianteira 4x2";
  }
}
