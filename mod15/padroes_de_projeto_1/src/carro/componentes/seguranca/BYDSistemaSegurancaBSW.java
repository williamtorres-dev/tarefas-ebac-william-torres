package carro.componentes.seguranca;

public class BYDSistemaSegurancaBSW implements ISistemaSeguranca {
  @Override
  public void ativarSistema() {
    System.out.println("Sistema de alerta de ponto cego BYD ativado.");
  }

  @Override
  public String tipoSistema() {
    return "Blind Spot Warning (BSW)";
  }
}
