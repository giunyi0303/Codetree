

import java.util.Scanner;

public class Main {
    private static int[][] grid;
    private static int n;
    private static int m;
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        if (m == 1) {
            ans = 2 * n;
        } else {
            check_row();
            check_col();
        }

        System.out.println(ans);
        sc.close();
    }

    private static void check_row() {
        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 1; j < n; j++) {
                if (grid[i][j] == grid[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= m) {
                    ans++;
                    break;
                }
            }
        }
    }

    private static void check_col() {
        for (int j = 0; j < n; j++) {
            int count = 1;

            for (int i = 1; i < n; i++) {
                if (grid[i][j] == grid[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= m) {
                    ans++;
                    break;
                }
            }
        }
    }
}