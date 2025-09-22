import carros.Carro;
import carros.Esportivo;
import carros.Sedan;
import carros.SUV;

public class Principal {
  public static void main(String[] args) {
    Garagem<Carro> garagem = new Garagem<>();
    garagem.adicionarCarro(new Esportivo("Porsche", "Vermelho"));
    garagem.adicionarCarro(new Sedan("Civic", "Azul"));
    garagem.adicionarCarro(new Sedan("Fusion", "Prata"));
    garagem.adicionarCarro(new SUV("Renegade", "Branco"));
    garagem.adicionarCarro(new SUV("Sportage", "Preto"));
    garagem.listarCarros();
  }
}
