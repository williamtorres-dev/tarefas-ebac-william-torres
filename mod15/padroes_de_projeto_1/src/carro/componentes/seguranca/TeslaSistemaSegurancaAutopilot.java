package carro.componentes.seguranca;

public class TeslaSistemaSegurancaAutopilot implements ISistemaSeguranca {
  @Override
  public void ativarSistema() {
    System.out.println("Sistema Autopilot da Tesla ativado.");
  }

  @Override
  public String tipoSistema() {
    return "Autopilot";
  }
}
