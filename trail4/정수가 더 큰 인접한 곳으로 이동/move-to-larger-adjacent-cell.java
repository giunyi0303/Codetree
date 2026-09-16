import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int[][] grid;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };
    private static ArrayList<Integer> arr;
    private static int n;
    private static int r;
    private static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        arr = new ArrayList<>();
        arr.add(grid[r][c]);
        check();

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    private static void check() {
        int num = grid[r][c];

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && num < grid[nx][ny]) {

                r = nx;
                c = ny;
                arr.add(grid[r][c]);
                check();
                return;
            }
        }

    }
}