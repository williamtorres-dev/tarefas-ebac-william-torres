package carro.fabrica;

import carro.componentes.motor.IMotor;
import carro.componentes.motor.ToyotaMotorFlex2_0;
import carro.componentes.transmissao.ITransmissao;
import carro.componentes.transmissao.ToyotaCVT;
import carro.componentes.entretenimento.ISistemaEntretenimento;
import carro.componentes.entretenimento.ToyotaSistemaMultimidia10;
import carro.componentes.suspensao.ISuspensao;
import carro.componentes.suspensao.ToyotaSuspensaoIndependente;
import carro.componentes.rodas.IRodas;
import carro.componentes.rodas.ToyotaRoda15Aco;
import carro.componentes.seguranca.ISistemaSeguranca;
import carro.componentes.seguranca.ToyotaSistemaSegurancaTSS;
import carro.componentes.tracao.ITipoTracao;
import carro.componentes.tracao.ToyotaTipoTracaoDianteira;

public class ToyotaFactory implements IFabricaCarro {
  @Override
  public IMotor criarMotor() {
    return new ToyotaMotorFlex2_0();
  }

  @Override
  public ITransmissao criarTransmissao() {
    return new ToyotaCVT();
  }

  @Override
  public ISistemaEntretenimento criarSistemaEntretenimento() {
    return new ToyotaSistemaMultimidia10();
  }

  @Override
  public ISuspensao criarSuspensao() {
    return new ToyotaSuspensaoIndependente();
  }

  @Override
  public IRodas criarRodas() {
    return new ToyotaRoda15Aco();
  }

  @Override
  public ISistemaSeguranca criarSistemaSeguranca() {
    return new ToyotaSistemaSegurancaTSS();
  }

  @Override
  public ITipoTracao criarTipoTracao() {
    return new ToyotaTipoTracaoDianteira();
  }
}