package carro.fabrica;

import carro.componentes.motor.IMotor;
import carro.componentes.motor.TeslaMotorEletrico;
import carro.componentes.transmissao.ITransmissao;
import carro.componentes.transmissao.TeslaTransmissaoAutomatica;
import carro.componentes.entretenimento.ISistemaEntretenimento;
import carro.componentes.entretenimento.TeslaSistemaTouch15;
import carro.componentes.suspensao.ISuspensao;
import carro.componentes.suspensao.TeslaSuspensaoPneumatica;
import carro.componentes.rodas.IRodas;
import carro.componentes.rodas.TeslaRoda18Eletrica;
import carro.componentes.seguranca.ISistemaSeguranca;
import carro.componentes.seguranca.TeslaSistemaSegurancaAutopilot;
import carro.componentes.tracao.ITipoTracao;
import carro.componentes.tracao.TeslaTipoTracaoEletrica;

public class TeslaFactory implements IFabricaCarro {
  @Override
  public IMotor criarMotor() {
    return new TeslaMotorEletrico();
  }

  @Override
  public ITransmissao criarTransmissao() {
    return new TeslaTransmissaoAutomatica();
  }

  @Override
  public ISistemaEntretenimento criarSistemaEntretenimento() {
    return new TeslaSistemaTouch15();
  }

  @Override
  public ISuspensao criarSuspensao() {
    return new TeslaSuspensaoPneumatica();
  }

  @Override
  public IRodas criarRodas() {
    return new TeslaRoda18Eletrica();
  }

  @Override
  public ISistemaSeguranca criarSistemaSeguranca() {
    return new TeslaSistemaSegurancaAutopilot();
  }

  @Override
  public ITipoTracao criarTipoTracao() {
    return new TeslaTipoTracaoEletrica();
  }
}