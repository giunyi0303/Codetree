import java.util.*;

public class Main {
    private static boolean[][] map;
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            map[row][col] = true;
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int nx = row + dx[j];
                int ny = col + dy[j];
                if (nx > -1 && nx < n && ny > -1 && ny < n && map[nx][ny] == true) {
                    count++;
                }

            }

            if (count == 3) {
                System.out.println(1);
            } else {
                System.out.println(0);

            }

        }

    }
}