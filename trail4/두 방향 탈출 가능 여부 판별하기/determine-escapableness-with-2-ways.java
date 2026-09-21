import java.util.Scanner;

  public class Main {
      private static int n;
      private static int m;
      private static int[][] grid;
      private static boolean[][] visited;
      private static boolean found;

      private static int[] dx = {1,0};
      private static int[] dy = {0,1};

      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          n = sc.nextInt();
          m = sc.nextInt();

          grid = new int[n][m];
          visited = new boolean[n][m];
          found = false;

          for (int i = 0; i < n; i++) {
              for (int j = 0; j < m; j++) {
                  grid[i][j] = sc.nextInt();
              }
          }

          dfs(0,0);

          System.out.print(found ? 1 : 0);
      }

      private static void dfs(int x, int y) {
          if (found) {
              return;
          }

          if (x == n - 1 && y == m - 1) {
              found = true;
              return;
          }

          visited[x][y] = true;

          for (int i = 0; i < 2; i++) {
              int nx = x + dx[i];
              int ny = y + dy[i];

              if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                  continue;
              }

              // 0은 벽, 1은 길
              if (visited[nx][ny] || grid[nx][ny] == 0) {
                  continue;
              }

              dfs(nx, ny);

              if (found) {
                  return;
              }
          }
      }
  }
  
    