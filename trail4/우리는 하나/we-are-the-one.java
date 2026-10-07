import java.util.*;
import java.io.*;

public class Main {
    private static int N, K, U, D;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Integer> ans = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ans.add(bfs(i, j));
                }
            }
        }

        int result = 0;
        for (int i = 0; i < K && !ans.isEmpty(); i++) {
            result += ans.poll();
        }

        System.out.println(result);
    }

    private static int bfs(int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.add(new int[] { i, j });

        int count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            count++;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(map[nx][ny] - map[x][y]);

                if (diff >= U && diff <= D) {
                    visited[nx][ny] = true;
                    queue.add(new int[] { nx, ny });
                }
            }
        }

        return count;
    }
}