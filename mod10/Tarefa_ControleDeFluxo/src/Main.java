import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaNotas media = new MediaNotas(scanner);
        media.lerNotas();
        double mediaCalculada = media.calcularMedia();
        String status = media.statusAluno();
        media.imprimirSatus(mediaCalculada, status);
    }
}