import java.util.Scanner;

public class ConversaoWrapper {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int valorPrimitivo = scanner.nextInt();

        Integer valorWrapper = Integer.valueOf(valorPrimitivo);

        System.out.println("Valor como tipo wrapper: " +  valorWrapper);

        scanner.close();
    }
}
