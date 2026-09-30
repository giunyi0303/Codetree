import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] startnode = new int[3];
        graph = new ArrayList<>();
        int[][] total = new int[4][N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            startnode[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[] { end, cost });
            graph.get(end).add(new int[] { start, cost });
        }
        for (int i = 0; i < 3; i++) {
            int[] temp = shortpath(startnode[i]);
            total[i] = temp;
        }
        for (int i = 1; i < N + 1; i++) {
            int count = 0;
            if (i == startnode[0] || i == startnode[1] || i == startnode[2]) {
                continue;
            }
            for (int j = 0; j < 3; j++) {
                count += total[j][i];
            }
        }
//        for (int i = 0; i < 4; i++) {
//        for (int j = 1; j < N + 1; j++) {
//            System.out.print(total[i][j]+" ");
//        }
//        System.out.println();
//    }

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            int nearest = Math.min(total[0][i], Math.min(total[1][i], total[2][i]));
            ans = Math.max(ans, nearest);
        }
        System.out.println(ans);

    }

    private static int[] shortpath(int node) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[node] = 0;
        queue.add(new int[] { node, dist[node] });
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curr = current[0];
            int currdist = current[1];

            if (dist[curr] < currdist) // 이미 갱신된거라면
            {
                continue;
            }
            for (int[] edge : graph.get(curr)) {
                int next = edge[0];
                int cost = edge[1];
                if (dist[next] > currdist + cost) {
                    dist[next] = currdist + cost;
                    queue.add(new int[] { next, dist[next] });
                }

            }

        }
        return dist;

    }

}