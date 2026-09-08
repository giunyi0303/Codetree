import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            temp[i] = Math.abs(arr[i] - h);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n - t; i++) {
            int count = 0;
            for (int j = 0; j < t; j++) {
                count += temp[i + j];
            }
            ans = Math.min(count, ans);

        }
        System.out.println(ans);

    }
}