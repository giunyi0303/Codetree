import java.util.*;

public class Main {
    private static int n;
    private static int a;
    private static int b;
    private static int c;
    private static int a2;
    private static int b2;
    private static int c2;
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        a2 = sc.nextInt();
        b2 = sc.nextInt();
        c2 = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                for (int k = 1; k <= n; k++) {

                    if (check(i, j, k)) {
                        ans++;
                    }

                }
            }
        }
        System.out.println(ans);
    }

    private static int distance(int x, int y) {
        int diff = Math.abs(x - y);
        return Math.min(diff, n - diff);
    }

    private static boolean check(int i, int j, int k) {
        boolean first = distance(i, a) <= 2 && distance(j, b) <= 2 && distance(k, c) <= 2;

        boolean second = distance(i, a2) <= 2 && distance(j, b2) <= 2 && distance(k, c2) <= 2;

        return first || second;
    }

}