import java.util.*;

public class Main {
    private static int[] arr = new int[101];
    private static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[n];
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
            positions[i] = sc.nextInt();
            arr[positions[i]] += candies[i];
        }
        for (int c = 0; c <= 100; c++) {
            int start = Math.max(0, c - k);
            int end = Math.min(100, c + k);

            int count = 0;

            for (int i = start; i <= end; i++) {
                count += arr[i];
            }

            ans = Math.max(ans, count);
        }
        System.out.println(ans);

    }
}