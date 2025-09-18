package carro.componentes.entretenimento;

public class ToyotaSistemaMultimidia10 implements ISistemaEntretenimento {
  @Override
  public void ligarSistema() {
    System.out.println("Sistema multimídia Toyota ligado com tela 10\"");
  }

  @Override
  public String tipoTela() {
    return "Touchscreen 10 polegadas";
  }
}
