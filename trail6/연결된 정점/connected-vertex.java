import java.util.*;
import java.io.*;

public class Main {
    private static int[] parents;
    private static int[] size;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("x")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int num = Integer.parseInt(st.nextToken());
                System.out.println(func1(num));
            }
        }

    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        int rootA = find(x);
        int rootB = find(y);

        if (rootA == rootB) {
            return;
        }

        parents[rootA] = rootB;
        size[rootB] += size[rootA];
    }

    private static int func1(int x) {
        return size[find(x)];
    }
}