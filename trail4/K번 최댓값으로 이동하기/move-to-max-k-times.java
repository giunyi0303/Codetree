import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static int[][] grid;
    private static int n, k;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        for (int i = 0; i < k; i++) {
            int[] next = bfs(r, c);
            if (next == null)
                break;
            r = next[1];
            c = next[2];
        }

        System.out.println((r + 1) + " " + (c + 1));
    }

    private static int[] bfs(int r, int c) {
        int current = grid[r][c];
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new ArrayDeque<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(b[0], a[0]); // 값 큰 순서
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]); // 행 작은 순서
            return Integer.compare(a[2], b[2]); // 열 작은 순서
        });

        queue.add(new int[] { r, c });
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (grid[nx][ny] >= current)
                    continue;

                visited[nx][ny] = true;
                queue.add(new int[] { nx, ny });
                pq.add(new int[] { grid[nx][ny], nx, ny });
            }
        }

        return pq.poll(); // 이동 가능한 칸이 없으면 null
    }
}