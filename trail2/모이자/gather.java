import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int distance = 0;
            for (int j = 0; j < n; j++) {
                distance += Math.abs(j-i)*a[j];
            }
            answer = Math.min(distance, answer);

        }
        System.out.println(answer);
    }
}