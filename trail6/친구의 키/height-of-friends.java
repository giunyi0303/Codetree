import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N + 1];
        int[] in = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            in[end]++;
        }
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i < N + 1; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur+" ");
            for (int num : graph[cur]) {
                in[num]--;
                if (in[num] == 0) {
                    queue.add(num);
                }
            }
        }

    }
}