package carro.componentes.motor;

public class PorscheMotorEletrico implements IMotor {
  @Override
  public void ligar() {
    System.out.println("Motor elétrico Porsche Macan ligado.");
  }

  @Override
  public String tipoCombustivel() {
    return "Elétrico";
  }

  @Override
  public int potenciaCV() {
    return 360;
  }
}
