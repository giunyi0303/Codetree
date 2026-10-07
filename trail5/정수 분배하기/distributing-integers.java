import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int max = 1;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(nums[i], max);
        }
        int left = 1;
        int right = max;
        int ans = 0;

        while (left <= right) {
            long count = 0;
            int mid = left + (right - left) / 2;
            for (int num : nums) {
                count += (num / mid);
            }
            if (count >= M) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);

    }
}
