package Soal3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard game = new LotreBoard();

        System.out.println("Selamat Datang di E-Lottery Gosok");

        boolean play = true;
        while (play) {
            game.displayBoard();
            System.out.print("Masukkan tebakan anda (baris dan kolom): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            play = game.guess(row, col);

            if (game.isGameOver()) {
                System.out.println("Selamat anda menang!");
                game.displayBoard();
                break;
            }
        }

        scanner.close();
    }
}
