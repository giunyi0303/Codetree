
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, C, ans;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        int[][] matrix = new int[N][N - M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대의 가치를 먼저 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                int[] temp = new int[M];

                for (int k = 0; k < M; k++) {
                    temp[k] = map[i][j + k];
                }

                matrix[i][j] = cal(temp, 0, 0);
            }
        }

        // 첫 번째 도둑의 구간 선택
        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 <= N - M; c1++) {

                // 두 번째 도둑의 구간 선택
                for (int r2 = r1; r2 < N; r2++) {
                    for (int c2 = 0; c2 <= N - M; c2++) {

                        // 같은 행에서 두 구간이 겹치면 제외
                        if (r1 == r2 && Math.abs(c1 - c2) < M) {
                            continue;
                        }

                        int value = matrix[r1][c1] + matrix[r2][c2];
                        ans = Math.max(ans, value);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static int cal(int[] temp, int count, int num) {
        if (count == temp.length) {
            return 0;
        }

        // 현재 물건을 선택하지 않기
        int result = cal(temp, count + 1, num);

        // 현재 물건을 선택하기
        int weight = temp[count];

        if (num + weight <= C) {
            int value = weight * weight + cal(temp, count + 1, num + weight);

            result = Math.max(result, value);
        }

        return result;
    }
}
