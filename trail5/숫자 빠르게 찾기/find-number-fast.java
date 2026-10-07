import java.io.*;
import java.util.*;

public class Main {
    private static int[] nums;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            ans[i] = fun1(Integer.parseInt(br.readLine()));
        }
        for (int answer : ans) {
            System.out.println(answer);
        }

    }

    private static int fun1(int f) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == f) {
                return mid + 1;
            }

            if (nums[mid] > f) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
