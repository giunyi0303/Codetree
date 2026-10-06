import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N * M + 1];
        for (int i = 0; i < N * M + 1; i++) {
            parents[i] = i;
        }
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M - 1; j++) {
                int s = i * M + j + 1;
                int e = s + 1;
                int c = Integer.parseInt(st.nextToken());

                edges.add(new int[] { s, e, c });
            }
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int s = i * M + j + 1;
                int e = s + M;
                int c = Integer.parseInt(st.nextToken());

                edges.add(new int[] { s, e, c });
            }
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
            if (count == N * M - 1) {
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