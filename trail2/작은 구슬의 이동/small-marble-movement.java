import java.util.*;

public class Main {
    private static int[] LR = { -1, 1 };
    private static int[] UD = { -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt() - 1;
        int C = sc.nextInt() - 1;
        String D = sc.next();
        if (D.equals("L")) {
            int direction = 0;
            for (int i = 0; i < T; i++) {
                int nx = C + LR[direction];
                if (nx == -1 || nx == N) {
                    direction = (direction + 1) % 2;
                } else {
                    C = nx;
                }
            }
        } else if (D.equals("R")) {
            int direction = 1;
            for (int i = 0; i < T; i++) {
                int nx = C + LR[direction];
                if (nx == -1 || nx == N) {
                    direction = (direction + 1) % 2;
                } else {
                    C = nx;
                }
            }

        } else if (D.equals("U")) {
            int direction = 0;
            for (int i = 0; i < T; i++) {
                int ny = R + UD[direction];
                if (ny == -1 || ny == N) {
                    direction = (direction + 1) % 2;
                } else {
                    R = ny;
                }
            }

        } else if (D.equals("D")) {
            int direction = 1;
            for (int i = 0; i < T; i++) {
                int ny = R + UD[direction];
                if (ny == -1 || ny == N) {
                    direction = (direction + 1) % 2; // change
                } else {
                    R = ny;
                }
            }

        }
        System.out.println((R + 1) + " " + (C + 1));

    }
}