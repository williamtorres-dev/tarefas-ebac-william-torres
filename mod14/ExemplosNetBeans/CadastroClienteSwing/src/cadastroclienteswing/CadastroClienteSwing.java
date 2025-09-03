package cadastroclienteswing;

import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import cadastroclienteswing.util.LookAndFeelConfigurator;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;
// import javaapplication1.dao.ClienteMapDAO;



/**
 * Classe principal da aplicação de Cadastro de Clientes.
 * Implementa melhorias de logging, tratamento de erros e antialiasing.
 * 
 * @author William Tôrres
 * @version 3.0
 */
public class CadastroClienteSwing {

    private static final Logger LOGGER = Logger.getLogger(CadastroClienteSwing.class.getName());

    public static void main(String[] args) {
        // --- START: Configuração do ConsoleHandler em UTF-8 ---
        Logger rootLogger = Logger.getLogger("");
        for (java.util.logging.Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        try {
            ch.setEncoding("UTF-8");
        } catch (Exception ignored) { }
        ch.setFormatter(new SimpleFormatter());
        rootLogger.addHandler(ch);
        rootLogger.setLevel(Level.INFO);
        // --- END: Configuração do ConsoleHandler em UTF-8 ---

        // Configurações de sistema antes da GUI
        configurarAntialiasing();
        
        // --- START: TESTE DE PERSISTÊNCIA (remova depois de depurar) ---
        // ClienteMapDAO dao = new ClienteMapDAO();
        // dao.testarPersistencia();
        // --- END: TESTE DE PERSISTÊNCIA ---
        
        // Inicializa GUI na EDT
        SwingUtilities.invokeLater(() -> {
            try {
                // Configura Look and Feel via utilitário
                LookAndFeelConfigurator.applySystemLookAndFeel();
                LOGGER.info("Look and Feel configurado com sucesso");
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Falha ao configurar Look and Feel", e);
                JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível aplicar tema nativo.\nUsando tema padrão.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
                );
            }

            try {
                // Criação e exibição da janela principal
                TelaPrincipal tela = new TelaPrincipal();
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
                LOGGER.info("TelaPrincipal exibida com sucesso");
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Erro ao exibir a interface", e);
                JOptionPane.showMessageDialog(
                    null,
                    "Erro ao iniciar a interface:\n" + e.getMessage(),
                    "Erro Fatal",
                    JOptionPane.ERROR_MESSAGE
                );
                System.exit(1);
            }
        });
    }

    /**
     * Configura propriedades de antialiasing para melhor renderização de texto.
     */
    private static void configurarAntialiasing() {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        LOGGER.info("Propriedades de antialiasing configuradas");
    }
}
