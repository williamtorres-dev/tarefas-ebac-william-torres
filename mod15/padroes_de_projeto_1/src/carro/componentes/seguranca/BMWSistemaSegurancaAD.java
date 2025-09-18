package carro.componentes.seguranca;

public class BMWSistemaSegurancaAD implements ISistemaSeguranca {
  @Override
  public void ativarSistema() {
    System.out.println("Sistema ativo de assistência à direção BMW ativado.");
  }

  @Override
  public String tipoSistema() {
    return "Assistance Driving";
  }
}
