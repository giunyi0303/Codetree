import java.util.*;

public class Main {
    private static int[] dx = new int[] { 1, 0, -1, 0 };
    private static int[] dy = new int[] { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int dirNum = 3;
        int x = 0, y = 0;

        int nx, ny;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                dirNum = (dirNum + 1) % 4;
            else if (s.charAt(i) == 'L') {
                dirNum = (dirNum - 1 + 4) % 4;
            } else {
                x = x + dx[dirNum];
                y = y + dy[dirNum];
            }

        }
        System.out.println(x + " " + y);
    }
}