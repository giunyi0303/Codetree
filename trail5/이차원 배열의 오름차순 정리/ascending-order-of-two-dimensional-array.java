import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long K = Long.parseLong(br.readLine());

        long left = 1;
        long right = (long) N * N;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min((long) N, mid / i);
            }

            if (count >= K) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}