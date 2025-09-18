package carro.fabrica;

import carro.componentes.motor.IMotor;
import carro.componentes.motor.BMwmotor320i;
import carro.componentes.transmissao.ITransmissao;
import carro.componentes.transmissao.BMWTransmissao8Marchas;
import carro.componentes.entretenimento.ISistemaEntretenimento;
import carro.componentes.entretenimento.BMWSistemaMultimidia12;
import carro.componentes.suspensao.ISuspensao;
import carro.componentes.suspensao.BMWSuspensaoAdaptativa;
import carro.componentes.rodas.IRodas;
import carro.componentes.rodas.BMWRoda19LigaLeve;
import carro.componentes.seguranca.ISistemaSeguranca;
import carro.componentes.seguranca.BMWSistemaSegurancaAD;
import carro.componentes.tracao.ITipoTracao;
import carro.componentes.tracao.BMwTipoTracaoTraction;

public class BMWFactory implements IFabricaCarro {
  @Override
  public IMotor criarMotor() {
    return new BMwmotor320i();
  }

  @Override
  public ITransmissao criarTransmissao() {
    return new BMWTransmissao8Marchas();
  }

  @Override
  public ISistemaEntretenimento criarSistemaEntretenimento() {
    return new BMWSistemaMultimidia12();
  }

  @Override
  public ISuspensao criarSuspensao() {
    return new BMWSuspensaoAdaptativa();
  }

  @Override
  public IRodas criarRodas() {
    return new BMWRoda19LigaLeve();
  }

  @Override
  public ISistemaSeguranca criarSistemaSeguranca() {
    return new BMWSistemaSegurancaAD();
  }

  @Override
  public ITipoTracao criarTipoTracao() {
    return new BMwTipoTracaoTraction();
  }
}