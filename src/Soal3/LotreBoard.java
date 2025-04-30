package Soal3;
import java.util.Random;

public class LotreBoard {
    char[][] board;
    boolean[][] revealed;
    int[][] data;
    int rows = 4;
    int cols = 5;
    int bombs = 2;

    LotreBoard() {
        board = new char[rows][cols];
        revealed = new boolean[rows][cols];
        data = new int[rows][cols];
        generateBoard();
    }

    public void generateBoard() {
        // Membuat tampilan awal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0;
            }
        }

        // Meletakkan bom random
        Random rand = new Random();
        int bombCount = 0;
        while (bombCount < bombs) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (data[r][c] == 0) {
                data[r][c] = 1; // 1 = bomb
                bombCount++;
            }
        }
    }

    // Menampilkan lotre
    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!revealed[i][j]) {
                    System.out.print("* ");
                } else {
                    if (data[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Koordinat tidak valid.");
            return true; // Permainan berlanjut
        }

        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true; // Permainan berlanjut
        }

        revealed[row][col] = true;
        if (data[row][col] == 1) {
            System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
            displayBoard();
            return false; // Game Over
        } else {
            System.out.println("Kotak Aman");
            return true; // Pemainan berlanjut
        }
    }

    public boolean isGameOver() {
        int safeOpened = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data[i][j] == 0 && revealed[i][j]) {
                    safeOpened++;
                }
            }
        }
        return safeOpened == (rows * cols - bombs);
    }
}
