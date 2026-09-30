import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static List<List<int[]>> graph;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(end).add(new int[] { start, cost });
        }
        System.out.println(func());

    }

    private static int func() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.add(new int[] { N, dist[N] });
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curr = current[0];
            int currdist = current[1];

            if (currdist > dist[curr]) {
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
        int minvlaue = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            minvlaue = Math.max(minvlaue, dist[i]);
        }
        return minvlaue;

    }
}