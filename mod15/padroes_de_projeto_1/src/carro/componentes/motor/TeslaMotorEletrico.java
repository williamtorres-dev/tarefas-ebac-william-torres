package carro.componentes.motor;

public class TeslaMotorEletrico implements IMotor {
  @Override
  public void ligar() {
    System.out.println("Motor elétrico Tesla Model Y ligado.");
  }

  @Override
  public String tipoCombustivel() {
    return "Elétrico";
  }

  @Override
  public int potenciaCV() {
    return 450;
  }
}
