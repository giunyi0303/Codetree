import java.util.*;

public class Main {
    private static int[] dx = { 0, 0, -1, 1 };
    private static int[] dy = { 1, -1, 0, 0 };
    private static int x = 0;
    private static int y = 0;
    private static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] dir = new char[n];
        int[] dist = new int[n];
        int direction = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            dir[i] = sc.next().charAt(0);
            dist[i] = sc.nextInt();
            if (dir[i] == 'E') {
                direction = 0;
            } else if (dir[i] == 'W') {
                direction = 1;
            } else if (dir[i] == 'N') {
                direction = 2;
            } else {
                direction = 3;
            }
            for (int j = 0; j < dist[i]; j++) {
                count++;
                x = x + dx[direction];
                y = y + dy[direction];
                if (x == 0 && y == 0) {
                    answer = count;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }

        }
        System.out.println(answer);

    }
}