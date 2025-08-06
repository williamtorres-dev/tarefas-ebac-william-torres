public class PessoaFisica extends Pessoa {
  private String cpf, dataNascimento, estadoCivil, nome, profissao, sexo, sobreNome;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getProfissao() {
    return profissao;
  }

  public void setProfissao(String profissao) {
    this.profissao = profissao;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getSobreNome() {
    return sobreNome;
  }

  public void setSobreNome(String sobreNome) {
    this.sobreNome = sobreNome;
  }

  public void imprimir() {
    System.out.println("Pessoa Física:");
    System.out.println("Nome: " + nome + " " + sobreNome);
    System.out.println("CPF: " + cpf);
    System.out.println("Data de Nascimento: " + dataNascimento);
    System.out.println("Estado Civil: " + estadoCivil);
    System.out.println("Profissão: " + profissao);
    System.out.println("Sexo: " + sexo);
    imprimirPessoa();
    System.out.println();
  }
}
