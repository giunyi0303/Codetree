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
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[101];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } else {
                    for (int k = x1[j]; k <= x2[j]; k++) {
                        arr[k]++;
                    }
                }
            }
            for (int a : arr) {
                if (a == n - 1) {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

}