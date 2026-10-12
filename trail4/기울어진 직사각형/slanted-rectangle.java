import java.util.*;
import java.io.*;

public class Main {
    private static int[] dx = { -1, -1, 1, 1 };
    private static int[] dy = { 1, -1, -1, 1 };
    private static int[][] arr;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int a = 1; a < N; a++) {
                    for (int b = 1; b < N; b++) {
                        ans = Math.max(ans, func(i, j, a, b));
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static int func(int x, int y, int a, int b) {
        int dir = 0;
        int count = 0;
        int sum = 0;
        int[] length = { a, b, a, b };

        while (dir < 4) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                sum += arr[nx][ny];
                x = nx;
                y = ny;
                count++;

                if (count == length[dir]) {
                    dir++;
                    count = 0;
                }
            } else {
                return 0;
            }
        }

        return sum;
    }
}