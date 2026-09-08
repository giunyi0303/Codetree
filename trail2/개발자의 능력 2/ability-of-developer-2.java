import java.util.*;

public class Main {
    private static boolean[] selected;
    private static int[] arr;
    private static int[] ablity;
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[6];
        ablity = new int[6];
        selected = new boolean[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }
        ans = Integer.MAX_VALUE;
        permutation(0);
        System.out.println(ans);
    }

    private static void count() {
        int team1 = ablity[0] + ablity[1];
        int team2 = ablity[2] + ablity[3];
        int team3 = ablity[4] + ablity[5];
        int max = Math.max(team1, Math.max(team2, team3));
        int min = Math.min(team1, Math.min(team2, team3));

        ans = Math.min(ans, Math.abs(max - min));
    }

    private static void permutation(int cnt) {
        if (cnt == 6) {
            count();
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (!selected[i]) {
                ablity[cnt] = arr[i];
                selected[i] = true;
                permutation(cnt + 1);
                selected[i] = false;
            }

        }

    }
}