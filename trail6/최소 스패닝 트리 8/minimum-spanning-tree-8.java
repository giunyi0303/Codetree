import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<int[]>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[] { e, c });
            graph.get(e).add(new int[] { s, c });
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        queue.add(new int[] { 1, 0 });
        int total = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int vertex = cur[0];
            int cost = cur[1];

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;
            total += cost;
            count++;

            if (count == N) {
                break;
            }

            for (int[] next : graph.get(vertex)) {
                if (!visited[next[0]]) {
                    queue.offer(new int[] { next[0], next[1] });
                }
            }
        }
        System.out.println(total);
    }

}