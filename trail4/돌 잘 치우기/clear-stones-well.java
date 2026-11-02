import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K;
    private static int[][] map;
    private static int[][] start_point;
    private static List<int[]> stones = new ArrayList<>();
    private static int[] dx = { 0, 0, 1, -1 };
    private static int[] dy = { 1, -1, 0, 0 };
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    stones.add(new int[] { i, j });
                }
            }
        }

        start_point = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            start_point[i][0] = Integer.parseInt(st.nextToken()) - 1;
            start_point[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        combination(0, 0);
        System.out.println(ans);
    } 
    private static void bfs() {
        int count = 0;
        boolean[][] visited = new boolean[N][N];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int[] start : start_point) {
            int r = start[0];
            int c = start[1];

            visited[r][c] = true;
            queue.add(new int[] { r, c });
            count++;
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (map[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[] { nx, ny });
                count++;
            }
        }

        ans = Math.max(ans, count);
    }

    private static void combination(int start, int selected) {
        if (selected == M) {
            bfs();
            return;
        }

        for (int i = start; i < stones.size(); i++) {
            int[] stone = stones.get(i);
            int r = stone[0];
            int c = stone[1];

            map[r][c] = 0;
            combination(i + 1, selected + 1);
            map[r][c] = 1;
        }
    }
}