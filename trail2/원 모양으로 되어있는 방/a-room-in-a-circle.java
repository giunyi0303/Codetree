import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int stand = i;
            int total_distance = 0;
            for (int j = 0; j < n; j++) {
                int distance = (j - i + n) % n;
                total_distance += arr[j] * distance;
            }
            answer = Math.min(answer, total_distance );
        }
        System.out.println(answer);

    }

}