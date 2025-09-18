package carro.fabrica;

import carro.componentes.motor.IMotor;
import carro.componentes.motor.PorscheMotorEletrico;
import carro.componentes.transmissao.ITransmissao;
import carro.componentes.transmissao.PorscheTransmissaoAutomatic;
import carro.componentes.entretenimento.ISistemaEntretenimento;
import carro.componentes.entretenimento.PorscheSistemaTouch10;
import carro.componentes.suspensao.ISuspensao;
import carro.componentes.suspensao.PorscheSuspensaoSport;
import carro.componentes.rodas.IRodas;
import carro.componentes.rodas.PorscheRoda20LigaLeve;
import carro.componentes.seguranca.ISistemaSeguranca;
import carro.componentes.seguranca.PorscheSistemaSegurancaPASM;
import carro.componentes.tracao.ITipoTracao;
import carro.componentes.tracao.PorscheTipoTracao4x4;

public class PorscheFactory implements IFabricaCarro {
  @Override
  public IMotor criarMotor() {
    return new PorscheMotorEletrico();
  }

  @Override
  public ITransmissao criarTransmissao() {
    return new PorscheTransmissaoAutomatic();
  }

  @Override
  public ISistemaEntretenimento criarSistemaEntretenimento() {
    return new PorscheSistemaTouch10();
  }

  @Override
  public ISuspensao criarSuspensao() {
    return new PorscheSuspensaoSport();
  }

  @Override
  public IRodas criarRodas() {
    return new PorscheRoda20LigaLeve();
  }

  @Override
  public ISistemaSeguranca criarSistemaSeguranca() {
    return new PorscheSistemaSegurancaPASM();
  }

  @Override
  public ITipoTracao criarTipoTracao() {
    return new PorscheTipoTracao4x4();
  }
}