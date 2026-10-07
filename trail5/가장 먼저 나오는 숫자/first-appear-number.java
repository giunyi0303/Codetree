import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] queries = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            queries[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            int answer = n;
            int target = queries[i];

            if (target > arr[n - 1]) {
                sb.append(-1).append('\n');
                continue;
            }

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] >= target) {
                    right = mid - 1;
                    answer = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (answer < n && arr[answer] == target) {
                sb.append(answer + 1).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        }

        System.out.print(sb);
    }
}