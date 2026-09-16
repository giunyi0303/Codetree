import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            // 양방향 연결
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        // 시작점은 방문 표시만 하고 개수에는 포함하지 않음
        visited[1] = true;
        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int current) {
        for (int next : graph[current]) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                dfs(next);
            }
        }
    }
}