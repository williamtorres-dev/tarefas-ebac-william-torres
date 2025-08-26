package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO {

  private Map<String, Cliente> map;

  public ClienteMapDAO() {
    this.map = new HashMap<>();
  }

  @Override
  public Boolean cadastrar(Cliente cliente) {
    if (this.map.containsKey(cliente.getCpf())) {
      return false;
    }
    this.map.put(cliente.getCpf(), cliente);
    return true;
  }

  @Override
  public void excluir(String cpf) {
    this.map.remove(cpf);
  }

  @Override
  public Cliente consultar(String cpf) {
    return this.map.get(cpf);
  }

  @Override
  public void alterar(Cliente cliente) {
    // Busca cliente original pelo CPF antigo
    Cliente clienteOriginal = this.map.get(cliente.getCpf());
    if (clienteOriginal != null) {
      // Se CPF mudou, remove antigo e adiciona novo
      if (!clienteOriginal.getCpf().equals(cliente.getCpf())) {
        this.map.remove(clienteOriginal.getCpf());
        this.map.put(cliente.getCpf(), cliente);
      } else {
        clienteOriginal.setNome(cliente.getNome());
        clienteOriginal.setTel(cliente.getTel());
        clienteOriginal.setNumero(cliente.getNumero());
        clienteOriginal.setEnd(cliente.getEnd());
        clienteOriginal.setCidade(cliente.getCidade());
        clienteOriginal.setEstado(cliente.getEstado());
      }
    }
  }

  @Override
  public Collection<Cliente> buscarTodos() {
    return this.map.values();
  }
}
