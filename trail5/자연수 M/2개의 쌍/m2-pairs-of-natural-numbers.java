import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long ans = Long.MIN_VALUE;
        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, (a, b) -> Long.compare(a[1], b[1]));

        int left = 0;
        int right = N - 1;

        while (left <= right) {
            long num = arr[left][1] + arr[right][1];
            ans = Math.max(num, ans);

            if(left == right)
            {
                break;
            }
            long count = Math.min(arr[left][0] , arr[right][0]);
            
            arr[left][0] -=count;
            arr[right][0] -=count;

            if (arr[left][0] == 0) {
                left++;
            }
            if (arr[right][0] == 0) {
                right--;
            }

        }
        System.out.println(ans);
    }
}