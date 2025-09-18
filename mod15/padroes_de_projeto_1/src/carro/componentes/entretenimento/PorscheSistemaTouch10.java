package carro.componentes.entretenimento;

public class PorscheSistemaTouch10 implements ISistemaEntretenimento {
  @Override
  public void ligarSistema() {
    System.out.println("Sistema multimídia Porsche ligado com tela 10\"");
  }

  @Override
  public String tipoTela() {
    return "Touchscreen 10 polegadas";
  }
}
