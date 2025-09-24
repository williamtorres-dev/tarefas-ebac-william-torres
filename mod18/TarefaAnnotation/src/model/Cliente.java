package model;

import annotations.Tabela;

@Tabela(value = "clientes", schema = "vendas", catalog = "empresa", descricao = "Tabela que armazena os dados dos clientes")
public class Cliente {
  private int id;
  private String nome;

  public Cliente(int id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return "Cliente: id=" + id + ", nome='" + nome + "'";
  }
}
