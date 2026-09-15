import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int ans;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < 2 * N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cal(k, i, j);

                }
            }
        }
        System.out.println(ans);

    }

    private static void cal(int k, int i, int j) {
        int cost = k * k + (k + 1) * (k + 1);
        int get = 0;

        for (int q = 0; q < N; q++) {
            for (int w = 0; w < N; w++) {
                if (Math.abs(q - i) + Math.abs(w - j) <= k) {
                    get += map[q][w];
                }
            }
        }

        if (get * M >= cost) {
            ans = Math.max(ans, get);
        }
    }
}
