import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if (opcao == null || "".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida, digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsultar(opcao)) {
                String cpfStr = JOptionPane.showInputDialog(null,
                        "Digite o CPF (somente números)",
                        "Consultar", JOptionPane.INFORMATION_MESSAGE);
                consultar(cpfStr);
            } else if ("3".equals(opcao)) {
                String cpfStr = JOptionPane.showInputDialog(null,
                        "Digite o CPF para exclusão",
                        "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                excluir(cpfStr);
            } else if ("4".equals(opcao)) {
                alterar();
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF inválido ou vazio", "Erro", JOptionPane.ERROR_MESSAGE);
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

    private static void excluir(String cpfStr) {
        if (cpfStr == null || cpfStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF inválido ou vazio", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cpf = cpfStr.trim(); // CPF agora é String, sem conversão
        Cliente cliente = iClienteDAO.consultar(cpf);
        if (cliente != null) {
            iClienteDAO.excluir(cpf);
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado para exclusão.", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterar() {
        String cpf = JOptionPane.showInputDialog(
                null,
                "Digite o CPF do cliente a ser alterado:",
                "Alteração",
                JOptionPane.INFORMATION_MESSAGE);

        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente clienteExistente = iClienteDAO.consultar(cpf.trim());
        if (clienteExistente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado para alteração.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String mensagemAtual = "Dados atuais do cliente:\n" + clienteExistente.toString() +
                "\n\nDigite os novos dados separados por vírgula:\nNome, CPF, Telefone, Endereço, Número, Cidade, Estado";

        String dadosNovos = JOptionPane.showInputDialog(
                null, mensagemAtual, "Alteração", JOptionPane.INFORMATION_MESSAGE);

        if (dadosNovos == null || dadosNovos.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dados para alteração não podem ser vazios.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] dadosSeparados = dadosNovos.split(",");
        if (dadosSeparados.length != 7) {
            JOptionPane.showMessageDialog(null, "Número incorreto de dados. Deve conter 7 campos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ATENÇÃO: Passe os campos conforme String!
        Cliente clienteAlterado = criarClienteComValidacao(dadosSeparados);
        if (clienteAlterado == null) {
            JOptionPane.showMessageDialog(null, "Erro ao validar os dados informados.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Permitir troca de CPF: remove o anterior e adiciona o novo (já ajustado no
        // DAO)
        iClienteDAO.excluir(clienteExistente.getCpf());
        iClienteDAO.cadastrar(clienteAlterado);

        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso:\n" + clienteAlterado.toString(),
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void cadastrar(String dados) {
        if (dados == null || dados.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dados para cadastro não podem ser vazios.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] dadosSeparados = dados.split(",");
        if (dadosSeparados.length != 7) {
            JOptionPane.showMessageDialog(null, "Número incorreto de dados para cadastro. Esperado 7 campos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Cliente cliente = criarClienteComValidacao(dadosSeparados);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Erro na criação do cliente. Verifique os dados e tente novamente.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Cliente criarClienteComValidacao(String[] dadosSeparados) {
        try {
            String nome = dadosSeparados[0].trim();
            String cpf = dadosSeparados[1].trim();
            String tel = dadosSeparados[2].trim();
            String end = dadosSeparados[3].trim();
            String numStr = dadosSeparados[4].trim();
            String cidade = dadosSeparados[5].trim();
            String estado = dadosSeparados[6].trim();

            // Conversão do número (campo opcional)
            Integer numero = numStr.isEmpty() ? null : Integer.valueOf(numStr);

            // Validação essencial
            if (nome.isEmpty() || cpf.isEmpty()) {
                return null;
            }

            return new Cliente(
                    nome,
                    cpf,
                    tel,
                    end.isEmpty() ? null : end,
                    numero,
                    cidade.isEmpty() ? null : cidade,
                    estado.isEmpty() ? null : estado);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo: ", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }

}
