import java.util.*;

public class Main {
    private static int[][] map;
    private static int n;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();

        map = new int[n][n];
        int[][] dis = new int[n][n];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], -1);
 
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 3) {
                    dis[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (map[nx][ny] == 1 || dis[nx][ny] != -1) {
                    continue;
                }

                dis[nx][ny] = dis[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    sb.append(dis[i][j]).append(' ');
                } else {
                    sb.append(0).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}