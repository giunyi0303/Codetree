  import java.util.Scanner;

  public class Main {

      // 상, 하, 좌, 우
      private static final int[] dx = {-1, 1, 0, 0};
      private static final int[] dy = {0, 0, -1, 1};

      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          int n = sc.nextInt();
          int m = sc.nextInt();
          int t = sc.nextInt();

          int[][] grid = new int[n][n];

          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                  grid[i][j] = sc.nextInt();
              }
          }

          int[][] marbles = new int[m][2];
          boolean[] alive = new boolean[m];

          for (int i = 0; i < m; i++) {
              // 입력은 1부터 시작하므로 바로 0부터 시작하는 좌표로 변환
              marbles[i][0] = sc.nextInt() - 1;
              marbles[i][1] = sc.nextInt() - 1;
              alive[i] = true;
          }

          for (int second = 0; second < t; second++) {
              int[][] count = new int[n][n];

              // 모든 구슬 이동
              for (int i = 0; i < m; i++) {
                  if (!alive[i]) {
                      continue;
                  }

                  int currentX = marbles[i][0];
                  int currentY = marbles[i][1];

                  int maxValue = Integer.MIN_VALUE;
                  int bestX = currentX;
                  int bestY = currentY;

                  for (int dir = 0; dir < 4; dir++) {
                      int nx = currentX + dx[dir];
                      int ny = currentY + dy[dir];

                      if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                          continue;
                      }

                      if (grid[nx][ny] > maxValue) {
                          maxValue = grid[nx][ny];
                          bestX = nx;
                          bestY = ny;
                      }
                  }

                  marbles[i][0] = bestX;
                  marbles[i][1] = bestY;

                  count[bestX][bestY]++;
              }

              // 모든 구슬이 이동한 후 충돌 처리
              for (int i = 0; i < m; i++) {
                  if (!alive[i]) {
                      continue;
                  }

                  int x = marbles[i][0];
                  int y = marbles[i][1];

                  if (count[x][y] >= 2) {
                      alive[i] = false;
                  }
              }
          }

          int answer = 0;

          for (int i = 0; i < m; i++) {
              if (alive[i]) {
                  answer++;
              }
          }

          System.out.println(answer);
      }
  }
