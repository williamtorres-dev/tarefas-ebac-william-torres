import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        while (true) {
            String opcao = JOptionPane.showInputDialog(
                    null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Menu Principal",
                    JOptionPane.INFORMATION_MESSAGE);

            if (opcao == null || opcao.trim().isEmpty()) {
                sair();
            }

            switch (opcao) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    consultar();
                    break;
                case "3":
                    excluir();
                    break;
                case "4":
                    alterar();
                    break;
                case "5":
                    sair();
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida!",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void cadastrar() {
        String nome = JOptionPane.showInputDialog(null, "Nome:", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cpf = JOptionPane.showInputDialog(null, "CPF:", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String telefone = JOptionPane.showInputDialog(null, "Telefone:", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        String endereco = JOptionPane.showInputDialog(null, "Endereço:", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        String numeroStr = JOptionPane.showInputDialog(null, "Número:", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        String cidade = JOptionPane.showInputDialog(null, "Cidade:", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        String estado = JOptionPane.showInputDialog(null, "Estado:", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        Integer numero = null;
        if (numeroStr != null && !numeroStr.trim().isEmpty()) {
            try {
                numero = Integer.valueOf(numeroStr.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Cliente cliente = new Cliente(
                nome.trim(),
                cpf.trim(),
                telefone != null ? telefone.trim() : null,
                endereco != null ? endereco.trim() : null,
                numero,
                cidade != null ? cidade.trim() : null,
                estado != null ? estado.trim() : null);

        boolean sucesso = iClienteDAO.cadastrar(cliente);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultar() {
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF (somente números):", "Consultar",
                JOptionPane.INFORMATION_MESSAGE);
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF inválido ou vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = iClienteDAO.consultar(cpf.trim());
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, cliente.toString(), "Detalhes do Cliente",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void excluir() {
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF para exclusão:", "Exclusão",
                JOptionPane.INFORMATION_MESSAGE);
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF inválido ou vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = iClienteDAO.consultar(cpf.trim());
        if (cliente != null) {
            iClienteDAO.excluir(cpf.trim());
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado para exclusão.", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterar() {
        String cpfAtual = JOptionPane.showInputDialog(
                null,
                "Digite o CPF do cliente a ser alterado:",
                "Alteração",
                JOptionPane.INFORMATION_MESSAGE);
        if (cpfAtual == null || cpfAtual.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente clienteExistente = iClienteDAO.consultar(cpfAtual.trim());
        if (clienteExistente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado para alteração.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nome = JOptionPane.showInputDialog(null, "Nome:", clienteExistente.getNome());
        String novoCpf = JOptionPane.showInputDialog(null, "CPF:", clienteExistente.getCpf());
        String telefone = JOptionPane.showInputDialog(null, "Telefone:", clienteExistente.getTel());
        String endereco = JOptionPane.showInputDialog(null, "Endereço:", clienteExistente.getEnd());
        String numeroStr = JOptionPane.showInputDialog(null, "Número:",
                clienteExistente.getNumero() != null ? clienteExistente.getNumero().toString() : "");
        String cidade = JOptionPane.showInputDialog(null, "Cidade:", clienteExistente.getCidade());
        String estado = JOptionPane.showInputDialog(null, "Estado:", clienteExistente.getEstado());

        Integer numero = null;
        if (numeroStr != null && !numeroStr.trim().isEmpty()) {
            try {
                numero = Integer.valueOf(numeroStr.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String[] dadosSeparados = {
                nome != null ? nome.trim() : "",
                novoCpf != null ? novoCpf.trim() : "",
                telefone != null ? telefone.trim() : "",
                endereco != null ? endereco.trim() : "",
                numero != null ? numero.toString() : "",
                cidade != null ? cidade.trim() : "",
                estado != null ? estado.trim() : ""
        };

        Cliente clienteAlterado = criarClienteComValidacao(dadosSeparados);
        if (clienteAlterado == null) {
            JOptionPane.showMessageDialog(null, "Erro ao validar os dados informados.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Se CPF mudou, remover o antigo e cadastrar novo
        if (!clienteAlterado.getCpf().equals(clienteExistente.getCpf())) {
            iClienteDAO.excluir(clienteExistente.getCpf());
        }
        iClienteDAO.cadastrar(clienteAlterado);

        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso:\n" + clienteAlterado.toString(),
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static Cliente criarClienteComValidacao(String[] dados) {
        try {
            String nome = dados[0].trim();
            String cpf = dados[1].trim();
            String tel = dados[2].trim();
            String end = dados[3].trim();
            String numStr = dados[4].trim();
            String cidade = dados[5].trim();
            String estado = dados[6].trim();

            Integer numero = numStr.isEmpty() ? null : Integer.valueOf(numStr);

            if (nome.isEmpty() || cpf.isEmpty()) {
                return null;
            }

            return new Cliente(
                    nome,
                    cpf,
                    tel.isEmpty() ? null : tel,
                    end.isEmpty() ? null : end,
                    numero,
                    cidade.isEmpty() ? null : cidade,
                    estado.isEmpty() ? null : estado);
        } catch (Exception e) {
            return null;
        }
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
