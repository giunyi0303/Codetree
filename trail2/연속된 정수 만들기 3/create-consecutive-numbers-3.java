import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = arr[1] - arr[0];
        int right = arr[2] - arr[1];
        int ans = Math.max(left, right) - 1;
        System.out.println(ans);
    }
}