import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] order;
    static boolean[] visited;
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        order = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[0] = 0;
        visited[0] = true;

        func(1);

        System.out.println(answer);
    }

    private static void func(int depth) {
        if (depth == N) {
            long cost = 0;

            for (int i = 0; i < N - 1; i++) {
                int moveCost = map[order[i]][order[i + 1]];
                if (moveCost == 0) {
                    return;
                }

                cost += moveCost;
            }

            // 마지막 지점에서 출발점으로 돌아갈 수 있는지도 확인
            int returnCost = map[order[N - 1]][0];

            if (returnCost == 0) {
                return;
            }

            cost += returnCost;

            answer = Math.min(answer, cost);
            return;
        }

        for (int next = 1; next < N; next++) {
            if (visited[next]) {
                continue;
            }

            order[depth] = next;
            visited[next] = true;

            func(depth + 1);

            visited[next] = false;
        }
    }
}