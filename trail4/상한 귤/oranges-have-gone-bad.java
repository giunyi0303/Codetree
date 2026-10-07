import java.util.*;
import java.io.*;

public class Main {
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };
    private static int N, K;
    private static int[][] dist;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        dist = new int[N][N];

        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    dist[i][j] = -1;
                } else if (map[i][j] == 1) {
                    dist[i][j] = -2;
                } else {
                    dist[i][j] = 0;
                    queue.add(new int[] { i, j });
                }
            }
        }

        bfs(queue);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(Deque<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (dist[nx][ny] != -2) {
                    continue;
                }

                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[] { nx, ny });
            }
        }
    }
}