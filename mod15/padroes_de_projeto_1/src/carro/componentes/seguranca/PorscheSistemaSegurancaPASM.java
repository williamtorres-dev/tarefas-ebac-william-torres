package carro.componentes.seguranca;

public class PorscheSistemaSegurancaPASM implements ISistemaSeguranca {
  @Override
  public void ativarSistema() {
    System.out.println("Sistema de controle de estabilidade Porsche ativado.");
  }

  @Override
  public String tipoSistema() {
    return "PASM - Porsche Active Suspension Management";
  }
}
