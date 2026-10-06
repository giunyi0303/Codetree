import java.io.*;
import java.util.*;

public class Main {
    private static int[] parents;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i; // 초기화
        }
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new int[] { s, e, c });
        }
        edges.sort((a, b) -> Integer.compare(a[2], b[2]));
        int total = 0;
        int count = 0;
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            int c = edge[2];
            if (find(s) == find(e)) {
                continue;
            }
            union(s, e);
            total += c;
            count++;
            if (count == N - 1) {
                break;
            }

        }
        System.out.println(total);

    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);

    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parents[rootA] = rootB;
    }

}
