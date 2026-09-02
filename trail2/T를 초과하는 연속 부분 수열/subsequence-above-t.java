import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > t) {
                count++;
            } else {
                count = 0;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}