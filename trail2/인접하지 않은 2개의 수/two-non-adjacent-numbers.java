import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                if (Math.abs(i - j) >= 2) {
                    sum = arr[i] + arr[j];
                }
                answer = Math.max(answer, sum);
            }
        }
        System.out.println(answer);
    }
}