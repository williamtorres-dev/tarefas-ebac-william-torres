package cadastroclienteswing.util;

import javax.swing.UIManager;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Utilitário responsável pela configuração de Look and Feel.
 */
public class LookAndFeelConfigurator {

    private static final Logger LOGGER = Logger.getLogger(LookAndFeelConfigurator.class.getName());

    /**
     * Tenta aplicar o Look and Feel nativo. Em caso de falha, aplica o tema cross-platform.
     * 
     * @throws Exception se não for possível carregar nenhum tema
     */
    public static void applySystemLookAndFeel() throws Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception primary) {
            LOGGER.log(Level.WARNING, "Erro no tema nativo", primary);
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
    }
}
