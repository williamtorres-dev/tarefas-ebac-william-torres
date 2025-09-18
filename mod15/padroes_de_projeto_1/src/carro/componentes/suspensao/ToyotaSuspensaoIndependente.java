package carro.componentes.suspensao;

public class ToyotaSuspensaoIndependente implements ISuspensao {
  @Override
  public void tipoSuspensao() {
    System.out.println("Suspensão independente Toyota com molas coil spring.");
  }
}
