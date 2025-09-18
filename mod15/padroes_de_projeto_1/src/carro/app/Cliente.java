package carro.app;

import carro.componentes.entretenimento.ISistemaEntretenimento;
import carro.componentes.motor.IMotor;
import carro.componentes.rodas.IRodas;
import carro.componentes.seguranca.ISistemaSeguranca;
import carro.componentes.suspensao.ISuspensao;
import carro.componentes.tracao.ITipoTracao;
import carro.componentes.transmissao.ITransmissao;
import carro.fabrica.IFabricaCarro;

public class Cliente {
  private IMotor motor;
  private IRodas rodas;
  private ISistemaEntretenimento sistemaEntretenimento;
  private ISistemaSeguranca sistemaSeguranca;
  private ISuspensao suspensao;
  private ITipoTracao tracao;
  private ITransmissao transmissao;

  public Cliente(IFabricaCarro fabrica) {
    motor = fabrica.criarMotor();
    rodas = fabrica.criarRodas();
    sistemaEntretenimento = fabrica.criarSistemaEntretenimento();
    sistemaSeguranca = fabrica.criarSistemaSeguranca();
    suspensao = fabrica.criarSuspensao();
    tracao = fabrica.criarTipoTracao();
    transmissao = fabrica.criarTransmissao();
  }

  public void infoCarro() {
    motor.ligar();
    System.out.println("Combustível: " + motor.tipoCombustivel());
    System.out.println("Potência: " + motor.potenciaCV() + " CV");
    rodas.tipoRoda();
    System.out.println("Tamanho do Aro: " + rodas.tamanhoAro() + " polegadas");
    sistemaEntretenimento.ligarSistema();
    System.out.println("Tela: " + sistemaEntretenimento.tipoTela());
    sistemaSeguranca.ativarSistema();
    System.out.println("Sistem de Segurança: " + sistemaSeguranca.tipoSistema());
    suspensao.tipoSuspensao();
    tracao.descreverTracao();
    System.out.println("Tipo de Tração: " + tracao.tipo());
    transmissao.mudarMarcha(1);
    System.out.println("Transmissão: " + transmissao.tipo());
  }
}
