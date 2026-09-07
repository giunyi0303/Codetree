import java.util.Scanner;

public class Main {

    private static final int SIZE = 19;

    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 } };

    private static boolean isInside(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private static boolean isFive(int[][] board, int row, int col, int dr, int dc, int stone) {
        int beforeRow = row - dr;
        int beforeCol = col - dc;

        if (isInside(beforeRow, beforeCol) && board[beforeRow][beforeCol] == stone) {
            return false;
        }

        for (int k = 0; k < 5; k++) {
            int nextRow = row + dr * k;
            int nextCol = col + dc * k;

            if (!isInside(nextRow, nextCol) || board[nextRow][nextCol] != stone) {
                return false;
            }
        }

        int afterRow = row + dr * 5;
        int afterCol = col + dc * 5;

        if (isInside(afterRow, afterCol) && board[afterRow][afterCol] == stone) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (board[row][col] == 0) {
                    continue;
                }

                int stone = board[row][col];

                for (int[] direction : DIRECTIONS) {
                    int dr = direction[0];
                    int dc = direction[1];

                    if (isFive(board, row, col, dr, dc, stone)) {
                        int middleRow = row + dr * 2;
                        int middleCol = col + dc * 2;

                        System.out.println(stone);
                        System.out.println((middleRow + 1) + " " + (middleCol + 1));

                        sc.close();
                        return;
                    }
                }
            }
        }

        System.out.println(0);
        sc.close();
    }
}