public class MacBookPro {

    private String nome;
    private String tipo;
    private String cor;
    private String tela;
    private String chip;
    private String memoria;
    private String armazenamento;
    private String adaptador;
    private String portas;
    private String teclado;
    private double preco;
    private boolean touchID;
    private boolean camera;
    private boolean microfones;
    private boolean altoFalantes;
    private boolean wifi;
    private boolean telaAtiva;

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @param cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     *
     * @param tela
     */
    public void setTela(String tela) {
        this.tela = tela;
    }

    /**
     *
     * @param telaAtiva
     */
    public void setTelaAtiva(boolean telaAtiva) {
        this.telaAtiva = telaAtiva;
    }

    /**
     *
     * @param chip
     */
    public void setChip(String chip) {
        this.chip = chip;
    }

    /**
     *
     * @param memoria
     */
    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    /**
     *
     * @param armazenamento
     */
    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    /**
     *
     * @param adaptador
     */
    public void setAdaptador(String adaptador) {
        this.adaptador = adaptador;
    }

    /**
     *
     * @param portas
     */
    public void setPortas(String portas) {
        this.portas = portas;
    }

    /**
     *
     * @param teclado
     */
    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }

    /**
     *
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     *
     * @param touchID
     */
    public void setTouchID(boolean touchID) {
        this.touchID = touchID;
    }

    /**
     *
     * @param camera
     */
    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    /**
     *
     * @param microfones
     */
    public void setMicrofones(boolean microfones) {
        this.microfones = microfones;
    }

    /**
     *
     * @param altoFalantes
     */
    public void setAltoFalantes(boolean altoFalantes) {
        this.altoFalantes = altoFalantes;
    }

    /**
     *
     * @param wifi
     */
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    /**
     * Método para autorizar pagamentos, se a propriedade touchID estiver como true,
     * imprime no console a mensagem de pagamento autorizado, se não, se estiver como false,
     * imprime no console a mensagem de pagamento recusado.
     */
    public void autorizarPagamentos() {
        if (this.touchID) {
            System.out.println("\nPagamento autorizado\n");
        } else {
            System.out.println("\nPagamento recusado\n");
        }
    }

    /**
     * Método que simula uma chamada de vídeo, se as prorpiedades de camera, microfones, autoFalantes,
     * wifi e telaAtiva estivere como true, é exibido no console a mensagem de cahamada de vídeo aceita,
     * se não, se estiver ao menos uma propriedade como false, aparecerá no console a mensagem dizendo
     * que a chamada de vídeo foi recusada.
     */
    public void fazerChamadaDeVideo() {
        if (this.camera && this.microfones && this.altoFalantes && this.wifi && this.telaAtiva) {
            System.out.println("Chamada de vídeo aceita\n");
        } else {
            System.out.println("Chamada de vídeo recusada\n");
        }
    }

    /**
     *
     * @return se a propriedade telaAtiva estiver como true, retorna as informações do produto, se não,
     * se estiver como false, retorna uma String informando que a tela está desligada, portanto as informações
     * do produto não podem ser vistas.
     */
    public String apresentarDetalhes() {
        if (this.telaAtiva) {
            return "Modelo: " + nome + " " + tipo + " - " + cor + "\n" + "Tela: " + tela + "\n" +
                    "Chip: " + chip + "\n" + "Memoria: " + memoria + "\n" +
                    "Armazenamento: " +  armazenamento + "\n" + "Adaptador: " + adaptador + "\n" +
                    "Portas: " + portas + "\n" + "Teclado: " + teclado + "\n" +
                    "Preço: R$ " + String.format("%.2f", preco) + "\n";
        } else {
            return "Detalhes insdisponíveis para serem apresentados, pois a tela está desligada";
        }
    }
}
