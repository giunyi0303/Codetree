import java.util.*;

public class Main {
    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };
    private static char square[][];
    private static int x;
    private static int y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char alpha = 'A';
        int num = 1;
        int direction = 0;
        x = 0;
        y = 0;

        square = new char[n][m];
        while (num != n * m + 1) {
            square[x][y] = alpha;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || square[nx][ny] != 0) {
                direction = (direction + 1) % 4;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;
            num++;
            alpha = (char) ('A' + (alpha - 'A' + 1) % 26);

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}