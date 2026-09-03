import java.util.*;

public class Main {
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static int x;
    private static int y;
    private static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        int time = 0;
        int dir = 0;
        for (int i = 0; i < commands.length(); i++) {
            time++;
            if (commands.charAt(i) == 'F') {
                x = x + dx[dir];
                y = y + dy[dir];
            } else if (commands.charAt(i) == 'R') {
                dir = (dir + 1) % 4;
            } else {
                dir = (dir + 3) % 4;
            }
            if (x == 0 && y == 0) {
                answer = time;
                break;
            }

        }
        System.out.println(answer);
    }
}