public abstract class Pessoa {
  private String email, endereco, telefone;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public void imprimirPessoa() {
    System.out.println("Email: " + getEmail());
    System.out.println("Endereço: " + getEndereco());
    System.out.println("Telefone: " + getTelefone());
  }
}
