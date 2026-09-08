import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        int[] arr = new int[11];
        for (int i = 0; i < 11; i++) {
            arr[i] = 2;
        }
        for (int i = 0; i < N; i++) {
            int pigeon = sc.nextInt();
            int moveDir = sc.nextInt();
            if (arr[pigeon] == 2) {
                arr[pigeon] = moveDir;
            } else if (arr[pigeon] == 0 && moveDir == 1) {
                ans++;
                arr[pigeon] = 1;

            } else if (arr[pigeon] == 1 && moveDir == 0) {
                ans++;
                arr[pigeon] = 0;
            }
        }
        System.out.println(ans);
    }

}