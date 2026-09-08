import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    int st1 = Math.abs(i - a);
                    int st2 = Math.abs(j - b);
                    int st3 = Math.abs(k - c);
                    if (st1 <= 2 || st2 <= 2 || st3 <= 2) {
                        cnt++;
                    }

                }
            }
        }
        System.out.println(cnt);
    }
}