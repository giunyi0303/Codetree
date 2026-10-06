import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] boxcost = new int[N];
        for (int i = 0; i < N; i++) {
            boxcost[i] = Integer.parseInt(br.readLine());
        }
        int[][] edgecost = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                edgecost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[N];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < N; i++) {
            queue.offer(new int[] { i, boxcost[i] });
        }
        int total = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int ver = cur[0];
            int cost = cur[1];
            if (visited[ver]) {
                continue;
            }
            visited[ver] = true;
            total += cost;
            count++;
            if (count == N) {
                break;
            }
            for (int next = 0; next < N; next++) {
                if (!visited[next]) {
                    queue.add(new int[] { next, edgecost[next][ver] });
                }
            }

        }
        System.out.println(total);

    }

}
