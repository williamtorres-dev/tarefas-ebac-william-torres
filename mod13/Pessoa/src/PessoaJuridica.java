public class PessoaJuridica extends Pessoa {
  private String cnpj, dataFundacao, inscricao, naturezaJuridica, nomeFantasia, objetoSocial, razaoSocial;

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getDataFundacao() {
    return dataFundacao;
  }

  public void setDataFundacao(String dataFundacao) {
    this.dataFundacao = dataFundacao;
  }

  public String getInscricao() {
    return inscricao;
  }

  public void setInscricao(String inscricao) {
    this.inscricao = inscricao;
  }

  public String getNaturezaJuridica() {
    return naturezaJuridica;
  }

  public void setNaturezaJuridica(String naturezaJuridica) {
    this.naturezaJuridica = naturezaJuridica;
  }

  public String getNomeFantasia() {
    return nomeFantasia;
  }

  public void setNomeFantasia(String nomeFantasia) {
    this.nomeFantasia = nomeFantasia;
  }

  public String getObjetoSocial() {
    return objetoSocial;
  }

  public void setObjetoSocial(String objetoSocial) {
    this.objetoSocial = objetoSocial;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public void imprimir() {
    System.out.println("Pessoa Jurídica:");
    System.out.println("Razão Social: " + razaoSocial);
    System.out.println("Nome Fantasia: " + nomeFantasia);
    System.out.println("CNPJ: " + cnpj);
    System.out.println("Data de Fundação: " + dataFundacao);
    System.out.println("Inscrição: " + inscricao);
    System.out.println("Natureza Jurídica: " + naturezaJuridica);
    System.out.println("Objeto Social: " + objetoSocial);
    imprimirPessoa(); // Imprime email, endereço e telefone
    System.out.println();
  }
}
