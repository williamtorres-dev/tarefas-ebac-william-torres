public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MacBookPro mac = new MacBookPro();

        mac.setTouchID(true);
        mac.autorizarPagamentos();

        mac.setCamera(true);
        mac.setMicrofones(true);
        mac.setAltoFalantes(true);
        mac.setWifi(true);
        mac.setTelaAtiva(true);
        mac.fazerChamadaDeVideo();

        mac.setNome("MacBook");
        mac.setTipo("Pro");
        mac.setCor("Preto-espacial");
        mac.setTela("Liquid Retina XDR de 14 polegadas com nano-texture");
        mac.setChip("Chip M4 Pro da Apple com CPU de 14 núcleos, GPU de 20 núcleos e Neural Engine de 16 núcleos");
        mac.setMemoria("Memória unificada de 24 GB");
        mac.setArmazenamento("SSD de 1 TB");
        mac.setAdaptador("Adaptador de energia USB‑C de 96W");
        mac.setPortas("Três portas Thunderbolt 5, porta HDMI, slot para cartão SDXC," +
                " entrada para fones de ouvido, porta MagSafe 3");
        mac.setTeclado("Magic Keyboard retroiluminado com Touch ID – Inglês (EUA)");
        mac.setPreco(31799.00);

        System.out.println(mac.apresentarDetalhes());
    }
}