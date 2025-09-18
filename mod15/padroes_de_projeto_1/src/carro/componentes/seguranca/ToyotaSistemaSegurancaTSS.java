package carro.componentes.seguranca;

public class ToyotaSistemaSegurancaTSS implements ISistemaSeguranca {
  @Override
  public void ativarSistema() {
    System.out.println("Sistema Toyota Safety Sense (TSS) ativado.");
  }

  @Override
  public String tipoSistema() {
    return "Toyota Safety Sense";
  }
}
