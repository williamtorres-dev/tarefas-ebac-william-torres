public class HelloWorld1 {
  public static void main(String[] args) {
    String ambiente = args[0];
    if (ambiente.equalsIgnoreCase("DEV")) {
      System.out.print("Executando em ambiente de DESENVOLVIMENTO");
    } else if (ambiente.equalsIgnoreCase("TEST")) {
      System.out.print("Executando em ambiente de TESTE");
    } else {
      System.out.print(ambiente);
    }
  }
}