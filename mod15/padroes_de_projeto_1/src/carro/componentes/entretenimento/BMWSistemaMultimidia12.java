package carro.componentes.entretenimento;

public class BMWSistemaMultimidia12 implements ISistemaEntretenimento {
  @Override
  public void ligarSistema() {
    System.out.println("Sistema multimídia BMW ligado com tela 12.3\"");
  }

  @Override
  public String tipoTela() {
    return "Touchscreen 12.3 polegadas";
  }
}
