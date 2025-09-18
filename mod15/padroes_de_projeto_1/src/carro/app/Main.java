package carro.app;

import carro.fabrica.BMWFactory;
import carro.fabrica.BYDFactory;
import carro.fabrica.IFabricaCarro;
import carro.fabrica.PorscheFactory;
import carro.fabrica.TeslaFactory;
import carro.fabrica.ToyotaFactory;

public class Main {
  public static void main(String[] args) {

    System.out.println("");
    System.out.println("--------------------------------");
    System.out.println("");

    IFabricaCarro fabricaBMW = new BMWFactory();
    Cliente clienteBMW = new Cliente(fabricaBMW);
    clienteBMW.infoCarro();

    System.out.println("");
    System.out.println("----------------------------------");
    System.out.println("");

    IFabricaCarro fabricaBYD = new BYDFactory();
    Cliente clienteBYD = new Cliente(fabricaBYD);
    clienteBYD.infoCarro();

    System.out.println("");
    System.out.println("------------------------------------");
    System.out.println("");

    IFabricaCarro fabricaPorsche = new PorscheFactory();
    Cliente clientePorsche = new Cliente(fabricaPorsche);
    clientePorsche.infoCarro();

    System.out.println("");
    System.out.println("------------------------------------");
    System.out.println("");

    IFabricaCarro fabricaTesla = new TeslaFactory();
    Cliente clienteTesla = new Cliente(fabricaTesla);
    clienteTesla.infoCarro();

    System.out.println("");
    System.out.println("-----------------------------");
    System.out.println("");

    IFabricaCarro fabricaToyota = new ToyotaFactory();
    Cliente clienteToyota = new Cliente(fabricaToyota);
    clienteToyota.infoCarro();
  }
}
