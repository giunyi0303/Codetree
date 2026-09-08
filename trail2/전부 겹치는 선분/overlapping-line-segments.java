import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        int[] arr = new int[101];

        for (int i = 0; i < n; i++) {
            for (int j = x1[i]; j <= x2[i]; j++) {
                arr[j]++;
            }
        }
        boolean flag = false;
        for (int a : arr) {
            if (a == n) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}