import java.util.*;

public class Main {
    private static int[] arr = new int[3];
    private static boolean[] selected = new boolean[10];
    private static int n;
    private static int[] num;
    private static int[] count1;
    private static int[] count2;
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        count1 = new int[n];
        count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }
        permutation(0);
        System.out.println(ans);
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            int cnt1 = 0;
            int cnt2 = 0;
            String str = String.valueOf(num[i]);
            int[] temp = new int[3];

            for (int j = 0; j < 3; j++) {
                temp[j] = str.charAt(j) - '0';
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (temp[j] == arr[k]) {
                        if (j == k) {
                            cnt1++;

                        } else {
                            cnt2++;
                        }

                    }

                }
            }
            if (cnt1 != count1[i] || cnt2 != count2[i]) {
                return false;
            }

        }
        return true;
    }

    public static void permutation(int cnt) {
        if (cnt == 3) {
            if (check()) {
                ans++;
            }

            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!selected[i]) {
                arr[cnt] = i;
                selected[i] = true;
                permutation(cnt + 1);
                selected[i] = false;

            }
        }
    }
}