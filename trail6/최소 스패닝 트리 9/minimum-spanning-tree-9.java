import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        List<List<int[]>> graph = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(n1).add(new int[] { n2, cost });
            graph.get(n2).add(new int[] { n1, cost });
        }
        int total = 0;
        int count = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.add(new int[] { 1, 0 }); // 1과 cost가 0인거
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int next = curr[0];
            int cost = curr[1];
            if (!visited[next]) {
                visited[next] = true;
                count++;
                total += cost;
                for (int[] edge : graph.get(next)) {
                    queue.add(new int[] { edge[0], edge[1] });
                }
            }
            if (count == N) {
                break;
            }

        }
        System.out.println(total);

    }

}