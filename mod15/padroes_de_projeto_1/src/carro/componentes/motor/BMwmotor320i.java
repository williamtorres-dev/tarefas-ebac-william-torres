package carro.componentes.motor;

public class BMwmotor320i implements IMotor {
  @Override
  public void ligar() {
    System.out.println("Motor 2.0 Turbo BMW 320i ligado.");
  }

  @Override
  public String tipoCombustivel() {
    return "Gasolina";
  }

  @Override
  public int potenciaCV() {
    return 184;
  }
}
