package carro.fabrica;

import carro.componentes.motor.IMotor;
import carro.componentes.motor.BYDMotorHibrido;
import carro.componentes.transmissao.ITransmissao;
import carro.componentes.transmissao.BYDTransmissaoCVT;
import carro.componentes.entretenimento.ISistemaEntretenimento;
import carro.componentes.entretenimento.BYDSistemaMultimidia10;
import carro.componentes.suspensao.ISuspensao;
import carro.componentes.suspensao.BYDSuspensaoIndependente;
import carro.componentes.rodas.IRodas;
import carro.componentes.rodas.BYDRoda17Aco;
import carro.componentes.seguranca.ISistemaSeguranca;
import carro.componentes.seguranca.BYDSistemaSegurancaBSW;
import carro.componentes.tracao.ITipoTracao;
import carro.componentes.tracao.BYDTipoTracao4x2;

public class BYDFactory implements IFabricaCarro {
  @Override
  public IMotor criarMotor() {
    return new BYDMotorHibrido();
  }

  @Override
  public ITransmissao criarTransmissao() {
    return new BYDTransmissaoCVT();
  }

  @Override
  public ISistemaEntretenimento criarSistemaEntretenimento() {
    return new BYDSistemaMultimidia10();
  }

  @Override
  public ISuspensao criarSuspensao() {
    return new BYDSuspensaoIndependente();
  }

  @Override
  public IRodas criarRodas() {
    return new BYDRoda17Aco();
  }

  @Override
  public ISistemaSeguranca criarSistemaSeguranca() {
    return new BYDSistemaSegurancaBSW();
  }

  @Override
  public ITipoTracao criarTipoTracao() {
    return new BYDTipoTracao4x2();
  }
}