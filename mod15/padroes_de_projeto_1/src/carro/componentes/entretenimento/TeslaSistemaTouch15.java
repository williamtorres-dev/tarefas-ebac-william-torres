package carro.componentes.entretenimento;

public class TeslaSistemaTouch15 implements ISistemaEntretenimento {
  @Override
  public void ligarSistema() {
    System.out.println("Sistema multimídia Tesla ligado com tela 15\"");
  }

  @Override
  public String tipoTela() {
    return "Touchscreen 15 polegadas";
  }
}
