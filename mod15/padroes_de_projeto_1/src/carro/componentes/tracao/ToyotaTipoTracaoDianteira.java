package carro.componentes.tracao;

public class ToyotaTipoTracaoDianteira implements ITipoTracao {
  @Override
  public void descreverTracao() {
    System.out.println("Tração dianteira Toyota.");
  }

  @Override
  public String tipo() {
    return "Dianteira 4x2";
  }
}
