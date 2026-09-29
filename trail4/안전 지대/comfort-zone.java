import java.util.*;

  public class Main {
      private static int[][] grid;
      private static int n, m;
      private static final int[] dx = {0, 0, -1, 1};
      private static final int[] dy = {-1, 1, 0, 0};

      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          n = sc.nextInt();
          m = sc.nextInt();

          grid = new int[n][m];
          int maxnum = 0;

          for (int i = 0; i < n; i++) {
              for (int j = 0; j < m; j++) {
                  grid[i][j] = sc.nextInt();
                  maxnum = Math.max(maxnum, grid[i][j]);
              }
          }

          int ans = 0;       // 최대 안전 영역 수
          int ansK = 1;      // 그때의 K

          for (int k = 1; k <= maxnum; k++) {
              boolean[][] visited = new boolean[n][m];
              int count = 0;

              for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                      if (grid[i][j] > k && !visited[i][j]) {
                          bfs(i, j, k, visited);
                          count++;
                      }
                  }
              }

              if (count > ans) {
                  ans = count;
                  ansK = k;
              }
          }

          System.out.print(ansK + " " + ans);
      }

      private static void bfs(int r, int c, int k, boolean[][] visited) {
          Deque<int[]> queue = new ArrayDeque<>();
          queue.add(new int[]{r, c});
          visited[r][c] = true;

          while (!queue.isEmpty()) {
              int[] cur = queue.poll();

              for (int i = 0; i < 4; i++) {
                  int nx = cur[0] + dx[i];
                  int ny = cur[1] + dy[i];

                  if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                  if (visited[nx][ny] || grid[nx][ny] <= k) continue;

                  visited[nx][ny] = true;
                  queue.add(new int[]{nx, ny});
              }
          }
      }
  }