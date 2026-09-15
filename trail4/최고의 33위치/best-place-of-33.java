import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        // 3×3 부분 격자의 시작 위치
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= N - 3; j++) {
                int count = 0;

                // 시작 위치부터 3행, 3열 확인
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        count += map[r][c];
                    }
                }

                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }
}