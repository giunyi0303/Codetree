import java.util.*;
import java.io.*;

public class Main {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int components = N;
        List<int[]> graph = new ArrayList<>();
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.add(new int[] { i, x, y });
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (union(n1, n2)) {
                components--;
            }
        }
        double ans = 0;
        List<double[]> edges = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                if (find(i) == find(j)) {
                    continue;
                } else {
                    int[] a = graph.get(i - 1);
                    int[] b = graph.get(j - 1);
                    double dx = (double) a[1] - b[1];
                    double dy = (double) a[2] - b[2];
                    double distance = Math.hypot(dx, dy);
                    edges.add(new double[] { i, j, distance });

                }
            }
        }
        edges.sort((a, b) -> Double.compare(a[2], b[2]));

        for (double[] edge : edges) {
            if (components == 1) {
                break;
            }

            int x = (int) edge[0];
            int y = (int) edge[1];

            if (union(x, y)) {
                ans += edge[2];
                components--;
            }
        }
        System.out.printf("%.2f", ans);

    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);
        if (rootA == rootB) {
            return false;
        }
        parents[rootA] = rootB;
        return true;
    }
}