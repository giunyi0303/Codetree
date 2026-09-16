import java.util.Scanner;

public class Main {
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };
    private static int[][] grid;
    private static int r;
    private static int c;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        bomb(grid[r][c]);
        grid[r][c] = 0;
        gravity();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void bomb(int power) {
        for (int dir = 0; dir < 4; dir++) {
            for (int dist = 1; dist < power; dist++) {
                int nx = r + dx[dir] * dist;
                int ny = c + dy[dir] * dist;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    break;
                }

                grid[nx][ny] = 0;
            }
        }
    }

    private static void gravity() {
        for (int col = 0; col < n; col++) {
            int writeRow = n - 1;

            for (int row = n - 1; row >= 0; row--) {
                if (grid[row][col] != 0) {
                    grid[writeRow][col] = grid[row][col];
                    writeRow--;
                }
            }

            while (writeRow >= 0) {
                grid[writeRow][col] = 0;
                writeRow--;
            }
        }
    }
}