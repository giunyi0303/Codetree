import java.util.*;

public class Main {
    private static int[] dx = { -1, 0, 1, 0, };
    private static int[] dy = { 0, 1, 0, -1, };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int dir = 0;
        int x = n / 2;
        int y = n / 2;
        int answer = board[x][y];
        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'R') {
                dir = (dir + 1) % 4;
            } else if (commands.charAt(i) == 'L') {
                dir = (dir + 3) % 4;
            } else {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx > -1 && nx < n && ny > -1 && ny < n) {
                    answer += board[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    continue;
                }

            }
        }
        System.out.println(answer);

    }
}