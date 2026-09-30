import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        List<List<int[]>> graph = new ArrayList<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
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
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[K] = 0;
        queue.add(new int[] { K, dist[K] });
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cur = current[0];
            int currdist = current[1];

            if (currdist > dist[cur]) {
                continue;
            }
            for (int[] edge : graph.get(cur)) {
                int next = edge[0];
                int cost = edge[1];
                if (dist[next] > currdist + cost) {
                    dist[next] = currdist + cost;
                    queue.add(new int[] { next, dist[next] });

                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }

        }

    }

}