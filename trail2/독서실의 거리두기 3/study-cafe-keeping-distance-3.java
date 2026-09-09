import java.util.*;

public class Main {
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = seats.charAt(i) - '0';
        }
        int index = 0;
        int minGap = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            if (arr[i] == 1) {
                int count = i - index;

                minGap = Math.min(minGap, count);

                if (count > 1) {
                    ans = Math.max(ans, count / 2);
                }

                index = i;
            }
        }
        System.out.println(Math.min(ans, minGap));

    }
}