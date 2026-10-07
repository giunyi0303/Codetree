import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] prefix = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            ans = Math.max(ans, prefix[i] - prefix[i - K]);
        }
        System.out.println(ans);
    }

}
