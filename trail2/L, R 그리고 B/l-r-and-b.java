import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static char[][] map = new char[10][10];
    private static int[][] dist = new int[10][10];

    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], -1); // -1: 아직 방문하지 않은 칸

            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 'L') {
                    queue.offer(new int[] { i, j });
                    dist[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (map[x][y] == 'B') {
                System.out.println(dist[x][y] - 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) {
                    continue;
                }

                if (map[nx][ny] == 'R' || dist[nx][ny] != -1) {
                    continue;
                }

                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[] { nx, ny });
            }
        }
    }
}