package carro.componentes.motor;

public class ToyotaMotorFlex2_0 implements IMotor {
  @Override
  public void ligar() {
    System.out.println("Motor 2.0 Flex Toyota ligado.");
  }

  @Override
  public String tipoCombustivel() {
    return "Flex (Gasolina/Etanol)";
  }

  @Override
  public int potenciaCV() {
    return 177;
  }
}
