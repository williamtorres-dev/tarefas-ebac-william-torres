package carro.componentes.motor;

public class BYDMotorHibrido implements IMotor {
  @Override
  public void ligar() {
    System.out.println("Motor híbrido BYD Song Pro ligado.");
  }

  @Override
  public String tipoCombustivel() {
    return "Plug-in Híbrido";
  }

  @Override
  public int potenciaCV() {
    return 321;
  }
}
