import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int[][] dist;
    private static boolean[][] visited;
    private static int N, sx, sy, ex, ey;
    private static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    private static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        visited = new boolean[N][N];
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;

        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[] { sx, sy });
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            if (x == ex && y == ey) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                queue.add(new int[] { nx, ny });
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//
//        }
        if (dist[ex][ey] != 0) {
            System.out.println(dist[ex][ey]);

        } else if (sx == ex && sy == ey) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }

    }
}