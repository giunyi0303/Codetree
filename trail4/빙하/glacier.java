import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] grid;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { 1, -1, 0, 0 };
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int count = 0;
        int time = 0;
        int g_count = 0;
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    count++;
                }
            }

        }
        while (count > 0) {
            visited = new boolean[n][m]; // 매 시간 새로 탐색
            cal();

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) {
                        for (int dir = 0; dir < 4; dir++) {
                            int x = i + dx[dir];
                            int y = j + dy[dir];

                            if (x < 0 || x >= n || y < 0 || y >= m)
                                continue;
                            if (grid[x][y] == 1) {
                                cnt++;
                                count--;
                                grid[x][y] = 0;
                            }
                        }
                    }
                }
            }

            time++; 
            g_count = cnt;
        }
        System.out.println(time + " " + g_count);

    }

    private static void cal() // 연결된 빙하 자리를 게산
    {
        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[] { 0, 0 }); // 시작은 무조건 빙하
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (grid[nx][ny] == 1) {
                    continue;
                }
                queue.add(new int[] { nx, ny });
                visited[nx][ny] = true;

            }

        }

    }

    private static void print() {
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
    }
}