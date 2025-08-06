public class App {
    public static void main(String[] args) {

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf("000.000.000-00");
        pessoaFisica.setNome("Rodrigo");
        pessoaFisica.setSobreNome("Pires");
        pessoaFisica.setSexo("Masculino");
        pessoaFisica.setDataNascimento("11/11/1111");
        pessoaFisica.setEmail("rodrigo_pires@email.com");
        pessoaFisica.setTelefone("(33) 33333-3333");
        pessoaFisica.setEndereco("Rua A, Nº 2, Complemento, Bairro, Cidade, Estado");
        pessoaFisica.setEstadoCivil("Solteiro");
        pessoaFisica.setProfissao("Especialista Back-End Java");

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj("60.701.190/0001-04");
        pessoaJuridica.setDataFundacao("22/08/1944");
        pessoaJuridica.setEmail("drinvest@itau-unibanco.com.br");
        pessoaJuridica.setEndereco(
                "Praça Alfredo Egydio de Souza Aranha, 100, Torre Olavo Setubal, Parque Jabaquara, São Paulo, SP, CEP 04344-902");
        pessoaJuridica.setInscricao("NIRE 35300010230");
        pessoaJuridica.setNaturezaJuridica("Sociedade Anônima Fechada");
        pessoaJuridica.setNomeFantasia("Itaú Unibanco S/A");
        pessoaJuridica.setObjetoSocial(
                "Atividade bancária em todas as modalidades autorizadas, inclusive operações de câmbio");
        pessoaJuridica.setRazaoSocial("Itaú Unibanco S.A.");
        pessoaJuridica.setTelefone("(11) 2794-3547");

        pessoaFisica.imprimir();
        pessoaJuridica.imprimir();
    }

}
