package javaapplication1.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javaapplication1.domain.Cliente;

/**
 *
 * @author William Tôrres
 */
public final class ClienteMapDAO implements IClienteDAO {
    
    private final Map<Long, Cliente> map;
    
    public ClienteMapDAO() {
        map = new TreeMap<>();
        carregarClientesDeArquivo();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
    map.remove(cpf);
}


    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        
        
        if (clienteCadastrado != null) { 
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setEnd(cliente.getEnd());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEstado(cliente.getEstado());
    } else {
                System.out.println("Cliente não encontrado para alterar.");
    }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public List<Cliente> todos() {
        return new ArrayList<>(map.values());
    }
    
    @Override
    public void salvarClientesEmArquivo() {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
        out.writeObject(new ArrayList<>(map.values()));
    } catch (Exception e) {
    }
}

public void carregarClientesDeArquivo() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
        List<Cliente> clientes = (List<Cliente>) in.readObject();
        for (Cliente c : clientes) {
            map.put(c.getCpf(), c);
        }
    } catch (Exception e) {}
}
}
