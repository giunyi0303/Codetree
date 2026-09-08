import java.util.*;

public class Main {
    private static final int N = 5;
    private static int[] dev = new int[N];
    private static int[] sel_dev = new int[N];
    private static boolean[] sel = new boolean[N];
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            dev[i] = sc.nextInt();
        }
        ans = Integer.MAX_VALUE;
        permutation(0);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);

    }

    private static void check() {
        int team1 = sel_dev[0] + sel_dev[1];
        int team2 = sel_dev[2] + sel_dev[3];
        int team3 = sel_dev[4];
        if (team1 != team2 && team2 != team3 && team3 != team1) {
            int max = Math.max(team1, Math.max(team2, team3));
            int min = Math.min(team1, Math.min(team2, team3));
            ans = Math.min(ans, max - min);
        }
    }

    private static void permutation(int cnt) {
        if (cnt == N) {
            check();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!sel[i]) {
                sel[i] = true;
                sel_dev[cnt] = dev[i];
                permutation(cnt + 1);
                sel[i] = false;
            }
        }
    }

}