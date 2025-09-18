package carro.fabrica;

import carro.componentes.entretenimento.ISistemaEntretenimento;
import carro.componentes.motor.IMotor;
import carro.componentes.rodas.IRodas;
import carro.componentes.seguranca.ISistemaSeguranca;
import carro.componentes.suspensao.ISuspensao;
import carro.componentes.tracao.ITipoTracao;
import carro.componentes.transmissao.ITransmissao;

public interface IFabricaCarro {
  IMotor criarMotor();

  IRodas criarRodas();

  ISistemaEntretenimento criarSistemaEntretenimento();

  ISistemaSeguranca criarSistemaSeguranca();

  ISuspensao criarSuspensao();

  ITipoTracao criarTipoTracao();

  ITransmissao criarTransmissao();
}
