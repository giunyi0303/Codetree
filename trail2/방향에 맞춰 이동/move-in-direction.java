import java.util.*;

public class Main {
    private static int[] x = { 0, 0, -1, 1 };
    private static int[] y = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curr_x = 0;
        int curr_y = 0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            switch (direction) {
            case 'E':
                curr_x += x[0] * distance;
                curr_y += y[0] * distance;
                break;
            case 'W':
                curr_x += x[1] * distance;
                curr_y += y[1] * distance;
                break;
            case 'S':
                curr_x += x[2] * distance;
                curr_y += y[2] * distance;
                break;
            case 'N':
                curr_x += x[3] * distance;
                curr_y += y[3] * distance;
                break;

            }

        }
        System.out.print(curr_y+" ");
        System.out.print(curr_x);
    }
}