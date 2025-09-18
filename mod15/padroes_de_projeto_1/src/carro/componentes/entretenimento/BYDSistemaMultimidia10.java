package carro.componentes.entretenimento;

public class BYDSistemaMultimidia10 implements ISistemaEntretenimento {
  @Override
  public void ligarSistema() {
    System.out.println("Sistema multimídia BYD ligado com tela 10\"");
  }

  @Override
  public String tipoTela() {
    return "Touchscreen 10 polegadas";
  }
}
