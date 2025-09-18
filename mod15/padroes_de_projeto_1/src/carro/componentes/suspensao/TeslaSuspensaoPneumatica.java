package carro.componentes.suspensao;

public class TeslaSuspensaoPneumatica implements ISuspensao {
  @Override
  public void tipoSuspensao() {
    System.out.println("Suspensão pneumática adaptativa Tesla.");
  }
}
