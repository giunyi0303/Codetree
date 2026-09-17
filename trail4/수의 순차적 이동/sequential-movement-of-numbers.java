import java.util.Scanner;

public class Main {
    private static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    private static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
    private static int[][] grid;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for (int i = 0; i < m; i++) {
            for (int num = 1; num <= n * n; num++) {
                cal(num);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void cal(int num) {

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == num) {
                    x = i;
                    y = j;

                }
            }
        }

        int maxValue = Integer.MIN_VALUE;

        int maxX = x;
        int maxY = y;

        // 주변 8방향 검사
        for (int dir = 0; dir < 8; dir++) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            if (grid[nx][ny] > maxValue) {
                maxValue = grid[nx][ny];

                maxX = nx;
                maxY = ny;
            }
        }

        // num과 주변에서 가장 큰 값의 위치 교환
        int temp = grid[x][y];

        grid[x][y] = grid[maxX][maxY];
        grid[maxX][maxY] = temp;
    }
}