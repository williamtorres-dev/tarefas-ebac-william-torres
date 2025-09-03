package javaapplication1.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.domain.Cliente;

/**
 * DAO para Cliente com persistência automática, backup e tratamento robusto de erros.
 * 
 * @author William Tôrres
 */
public final class ClienteMapDAO implements IClienteDAO {
    
    private static final Logger LOGGER = Logger.getLogger(ClienteMapDAO.class.getName());
    private static final String ARQUIVO_DADOS = "dados/clientes.dat";
    private static final String PASTA_BACKUP = "dados/backup";
    
    private final Map<Long, Cliente> map;
    
    public ClienteMapDAO() {
        this.map = new TreeMap<>();
        criarDiretoriosSeNecessario();
        carregarClientesDeArquivo();
    }
    
    /**
     * Cria diretórios necessários se não existirem.
     */
    private void criarDiretoriosSeNecessario() {
        try {
            Path dadosPath = Paths.get("dados");
            Path backupPath = Paths.get(PASTA_BACKUP);
            
            if (!Files.exists(dadosPath)) {
                Files.createDirectories(dadosPath);
                LOGGER.info("Diretório 'dados' criado");
            }
            
            if (!Files.exists(backupPath)) {
                Files.createDirectories(backupPath);
                LOGGER.info("Diretório 'backup' criado");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao criar diretórios", e);
        }
    }
    
    @Override
public Boolean cadastrar(Cliente cliente) {
    if (cliente == null) {
        LOGGER.warning("Tentativa de cadastrar cliente nulo");
        return false;
    }
    
    if (map.containsKey(cliente.getCpf())) {
        LOGGER.info("Tentativa de cadastrar cliente já existente: CPF " + cliente.getCpf());
        return false;
    }
    
    try {
        // Debug: verifica o estado antes de adicionar
        LOGGER.info("Adicionando cliente ao map: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
        
        map.put(cliente.getCpf(), cliente);
        
        // Debug: verifica se foi adicionado
        LOGGER.info("Cliente adicionado ao map. Total de clientes: " + map.size());
        
        // Força salvamento
        salvarClientesEmArquivo();
        
        // Debug: verifica se arquivo foi criado/atualizado
        File arquivo = new File(ARQUIVO_DADOS);
        LOGGER.info("Arquivo após salvamento - Existe: " + arquivo.exists() + 
                   ", Tamanho: " + arquivo.length() + " bytes");
        
        LOGGER.info("Cliente cadastrado com sucesso: " + cliente.getNome());
        return true;
        
    } catch (Exception e) {
        LOGGER.log(Level.SEVERE, "Erro ao cadastrar cliente", e);
        // Remove da memória se salvamento falhou
        map.remove(cliente.getCpf());
        throw new RuntimeException("Falha ao cadastrar cliente: " + e.getMessage(), e);
    }
}

    
    @Override
    public void excluir(Long cpf) {
        if (cpf == null) {
            LOGGER.warning("Tentativa de excluir cliente com CPF nulo");
            return;
        }
        
        Cliente clienteRemovido = map.remove(cpf);
        if (clienteRemovido != null) {
            try {
                salvarClientesEmArquivo();
                LOGGER.info(() -> "Cliente excluído com sucesso: " + clienteRemovido.getNome());
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Erro ao salvar após exclusão", e);
                // Restaura cliente na memória se salvamento falhou
                map.put(cpf, clienteRemovido);
                throw new RuntimeException("Falha ao excluir cliente: " + e.getMessage(), e);
            }
        } else {
            LOGGER.warning(() -> "Tentativa de excluir cliente inexistente: CPF " + cpf);
        }
    }
    
    @Override
    public void alterar(Cliente cliente) {
        if (cliente == null) {
            LOGGER.warning("Tentativa de alterar cliente nulo");
            return;
        }
        
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        
        if (clienteCadastrado != null) {
            // Guarda valores antigos para rollback em caso de erro
            String nomeAntigo = clienteCadastrado.getNome();
            Long telAntigo = clienteCadastrado.getTel();
            Integer numAntigo = clienteCadastrado.getNumero();
            String endAntigo = clienteCadastrado.getEnd();
            String cidadeAntiga = clienteCadastrado.getCidade();
            String estadoAntigo = clienteCadastrado.getEstado();
            
            try {
                clienteCadastrado.setNome(cliente.getNome());
                clienteCadastrado.setTel(cliente.getTel());
                clienteCadastrado.setNumero(cliente.getNumero());
                clienteCadastrado.setEnd(cliente.getEnd());
                clienteCadastrado.setCidade(cliente.getCidade());
                clienteCadastrado.setEstado(cliente.getEstado());
                
                salvarClientesEmArquivo();
                LOGGER.info(() -> "Cliente alterado com sucesso: " + cliente.getNome());
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Erro ao alterar cliente, fazendo rollback", e);
                // Rollback dos valores
                clienteCadastrado.setNome(nomeAntigo);
                clienteCadastrado.setTel(telAntigo);
                clienteCadastrado.setNumero(numAntigo);
                clienteCadastrado.setEnd(endAntigo);
                clienteCadastrado.setCidade(cidadeAntiga);
                clienteCadastrado.setEstado(estadoAntigo);
                
                throw new RuntimeException("Falha ao alterar cliente: " + e.getMessage(), e);
            }
        } else {
            LOGGER.warning(() -> "Cliente não encontrado para alterar: CPF " + cliente.getCpf());
            throw new IllegalArgumentException("Cliente não encontrado para alteração");
        }
    }
    
    @Override
    public Cliente consultar(Long cpf) {
        if (cpf == null) {
            LOGGER.warning("Tentativa de consultar cliente com CPF nulo");
            return null;
        }
        
        Cliente cliente = map.get(cpf);
        if (cliente == null) {
            LOGGER.info(() -> "Cliente não encontrado: CPF " + cpf);
        }
        return cliente;
    }
    
    @Override
    public List<Cliente> todos() {
        return new ArrayList<>(map.values());
    }
    
    @Override
    public void salvarClientesEmArquivo() {
        try {
            // Debug: mostra quantos clientes serão salvos
            LOGGER.info("Iniciando salvamento de " + map.size() + " clientes");

            // Cria backup antes de salvar
            criarBackup();

            // Cria diretório se não existir
            File arquivo = new File(ARQUIVO_DADOS);
            File diretorio = arquivo.getParentFile();
            if (!diretorio.exists()) {
                boolean criado = diretorio.mkdirs();
                LOGGER.info("Diretório criado: " + criado);
            }

            try (ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(ARQUIVO_DADOS))) {

                List<Cliente> listaParaSalvar = new ArrayList<>(map.values());
                LOGGER.info("Salvando lista com " + listaParaSalvar.size() + " clientes");

                out.writeObject(listaParaSalvar);
                out.flush(); // Força escrita

                LOGGER.info("Clientes salvos no arquivo com sucesso");
            }

            // Verifica se arquivo foi realmente criado/atualizado
            File arquivoVerificacao = new File(ARQUIVO_DADOS);
            LOGGER.info("Verificação pós-salvamento - Arquivo existe: " + 
                       arquivoVerificacao.exists() + ", Tamanho: " + 
                       arquivoVerificacao.length() + " bytes");

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar clientes no arquivo", e);
            throw new RuntimeException("Falha ao salvar dados: " + e.getMessage(), e);
        }
    }
        
    /**
     * Carrega clientes do arquivo principal ou do backup em caso de falha.
     */
    public void carregarClientesDeArquivo() {
        boolean carregouArquivoPrincipal = tentarCarregarArquivo(ARQUIVO_DADOS);
        
        if (!carregouArquivoPrincipal) {
            LOGGER.warning("Arquivo principal não encontrado ou corrompido, tentando backup");
            boolean carregouBackup = tentarCarregarBackupMaisRecente();
            
            if (!carregouBackup) {
                LOGGER.info("Nenhum arquivo encontrado, iniciando com base vazia");
            }
        }
    }
    
    /**
     * Tenta carregar um arquivo específico.
     */
    private boolean tentarCarregarArquivo(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            return false;
        }
        
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(caminhoArquivo))) {
            @SuppressWarnings("unchecked")
            List<Cliente> clientes = (List<Cliente>) in.readObject();
            
            map.clear();
            for (Cliente c : clientes) {
                map.put(c.getCpf(), c);
            }
            
            LOGGER.info(() -> "Clientes carregados com sucesso de: " + caminhoArquivo + 
                    " (" + clientes.size() + " registros)");
            return true;
            
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar arquivo: " + caminhoArquivo, e);
            return false;
        }
    }
    
    /**
     * Tenta carregar o backup mais recente.
     */
    private boolean tentarCarregarBackupMaisRecente() {
        try {
            Path pastaBackup = Paths.get(PASTA_BACKUP);
            if (!Files.exists(pastaBackup)) {
                return false;
            }
            
            // Lista arquivos de backup e pega o mais recente
            File[] backups = pastaBackup.toFile().listFiles(
                (dir, name) -> name.startsWith("clientes_backup_") && name.endsWith(".dat")
            );
            
            if (backups == null || backups.length == 0) {
                return false;
            }
            
            // Ordena por nome (que inclui timestamp) e pega o último
            java.util.Arrays.sort(backups, (a, b) -> b.getName().compareTo(a.getName()));
            String backupMaisRecente = backups[0].getAbsolutePath();
            
            return tentarCarregarArquivo(backupMaisRecente);
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao procurar backups", e);
            return false;
        }
    }
    
    /**
     * Cria backup do arquivo atual.
     */
    private void criarBackup() {
        try {
            File arquivoOriginal = new File(ARQUIVO_DADOS);
            if (!arquivoOriginal.exists()) {
                return; // Nada para fazer backup
            }
            
            String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
            );
            String nomeBackup = "clientes_backup_" + timestamp + ".dat";
            Path backupPath = Paths.get(PASTA_BACKUP, nomeBackup);
            
            Files.copy(arquivoOriginal.toPath(), backupPath, 
                      StandardCopyOption.REPLACE_EXISTING);
            
            LOGGER.info(() -> "Backup criado: " + nomeBackup);
            
            // Remove backups antigos (mantém apenas os 5 mais recentes)
            limparBackupsAntigos();
            
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Falha ao criar backup", e);
            // Não impede operação principal se backup falhar
        }
    }
    
    /**
     * Remove backups antigos, mantendo apenas os 5 mais recentes.
     */
    private void limparBackupsAntigos() {
        try {
            File pastaBackup = new File(PASTA_BACKUP);
            File[] backups = pastaBackup.listFiles(
                (dir, name) -> name.startsWith("clientes_backup_") && name.endsWith(".dat")
            );
            
            if (backups != null && backups.length > 5) {
                // Ordena por data (nome inclui timestamp)
                java.util.Arrays.sort(backups, (a, b) -> a.getName().compareTo(b.getName()));
                
                // Remove os mais antigos (mantém os 5 últimos)
                for (int i = 0; i < backups.length - 5; i++) {
                    if (backups[i].delete()) {
                        LOGGER.info("Backup antigo removido: " + backups[i].getName());
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Erro ao limpar backups antigos", e);
        }
    }
    
    /**
     * Retorna estatísticas do DAO para monitoramento.
     * @return */
    public String getEstatisticas() {
        return String.format("Total de clientes: %d, Arquivo: %s", 
                           map.size(), 
                           new File(ARQUIVO_DADOS).exists() ? "OK" : "Não encontrado");
    }
    
    /**
    * Método de depuração: salva, limpa memória e recarrega para verificar persistência.
    */
   public void testarPersistencia() {
       LOGGER.info("=== TESTE DE PERSISTÊNCIA ===");
       LOGGER.info("Clientes em memória antes do teste: " + map.size());

       // Força salvamento no arquivo
       salvarClientesEmArquivo();

       // Limpa a memória
       map.clear();
       LOGGER.info("Memória limpa. Total agora: " + map.size());

       // Recarrega do arquivo
       carregarClientesDeArquivo();
       LOGGER.info("Após recarregar do arquivo: " + map.size() + " clientes");

       // Lista os clientes carregados
       for (Cliente c : map.values()) {
           LOGGER.info("Cliente carregado: " + c);
       }
    }

}
