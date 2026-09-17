import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        int sx = 0;
        int sy = 0;
        int ex = n - 1;
        int ey = m - 1;

        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[] { sx, sy });
        visited[sx][sy] = true;
        boolean flag = true;
        while (!queue.isEmpty() && flag) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            if (x == ex && y == ey) {
                flag = false;
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && grid[nx][ny] == 1) {
                    queue.add(new int[] { nx, ny });
                    visited[nx][ny] = true;
                } else {
                    continue;
                }

            }
        }
        if (!flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}