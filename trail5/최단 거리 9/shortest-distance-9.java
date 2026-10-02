import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int[] prev = new int[N + 1];
        Arrays.fill(prev, -1);

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(end).add(new int[]{start, cost});
            graph.get(start).add(new int[]{end, cost});
        }

        st = new StringTokenizer(br.readLine());
        int startN = Integer.parseInt(st.nextToken());
        int endN = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1[1], o2[1])
        );

        queue.add(new int[]{startN, 0});
        dist[startN] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curr = current[0];
            int currdist = current[1];

            if (currdist > dist[curr]) {
                continue;
            }

            if (curr == endN) {
                break;
            }

            for (int[] edge : graph.get(curr)) {
                int next = edge[0];
                int cost = edge[1];

                if (dist[next] > currdist + cost) {
                    dist[next] = currdist + cost;
                    prev[next] = curr;
                    queue.add(new int[]{next, dist[next]});
                }
            }
        }

        if (dist[endN] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        List<Integer> seq = new ArrayList<>();

    
        for (int node = endN; node != -1; node = prev[node]) {
            seq.add(node);
        }

        Collections.reverse(seq);

        System.out.println(dist[endN]);

        for (int num : seq) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}