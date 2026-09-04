import java.util.*;

public class Main {
    private static int n;

    private static int cal(int[] x, int[] y, int index) {
        int prev_x = x[0];
        int prev_y = y[0];
        int distance = 0;
        for (int i = 1; i < n; i++) {
            if (i == index) {
                continue;
            } else {
                distance += Math.abs(prev_x - x[i]) + Math.abs(prev_y - y[i]);
                prev_x = x[i];
                prev_y = y[i];
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int dis = cal(x, y, i);
            answer = Math.min(dis, answer);
        }
        System.out.println(answer);
    }
}