

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
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cal(i, j);

            }
        }
        System.out.println(ans);
    }

    private static void block1(int i, int j) {
        int nx1 = i - 1;
        int ny1 = j;
        int nx2 = i;
        int ny2 = j + 1;
        if (nx1 > -1 && nx1 < n && nx2 > -1 && nx2 < n && ny1 > -1 && ny1 < m && ny2 > -1 && ny2 < m) {
            ans = Math.max(ans, grid[i][j] + grid[nx1][ny1] + grid[nx2][ny2]);
        }

    }

    private static void block2(int i, int j) {
        int nx1 = i - 1;
        int ny1 = j;
        int nx2 = i;
        int ny2 = j - 1;
        if (nx1 > -1 && nx1 < n && nx2 > -1 && nx2 < n && ny1 > -1 && ny1 < m && ny2 > -1 && ny2 < m) {
            ans = Math.max(ans, grid[i][j] + grid[nx1][ny1] + grid[nx2][ny2]);
        }

    }

    private static void block3(int i, int j) {
        int nx1 = i;
        int ny1 = j - 1;
        int nx2 = i + 1;
        int ny2 = j;
        if (nx1 > -1 && nx1 < n && nx2 > -1 && nx2 < n && ny1 > -1 && ny1 < m && ny2 > -1 && ny2 < m) {
            ans = Math.max(ans, grid[i][j] + grid[nx1][ny1] + grid[nx2][ny2]);
        }

    }

    private static void block4(int i, int j) {
        int nx1 = i;
        int ny1 = j + 1;
        int nx2 = i + 1;
        int ny2 = j;
        if (nx1 > -1 && nx1 < n && nx2 > -1 && nx2 < n && ny1 > -1 && ny1 < m && ny2 > -1 && ny2 < m) {
            ans = Math.max(ans, grid[i][j] + grid[nx1][ny1] + grid[nx2][ny2]);
        }

    }

    private static void block5(int i, int j) {
        int nx1 = i;
        int ny1 = j + 1;
        int nx2 = i;
        int ny2 = j + 2;
        if (nx1 > -1 && nx1 < n && nx2 > -1 && nx2 < n && ny1 > -1 && ny1 < m && ny2 > -1 && ny2 < m) {
            ans = Math.max(ans, grid[i][j] + grid[nx1][ny1] + grid[nx2][ny2]);
        }

    }

    private static void block6(int i, int j) {
        int nx1 = i + 1;
        int ny1 = j;
        int nx2 = i + 2;
        int ny2 = j;
        if (nx1 > -1 && nx1 < n && nx2 > -1 && nx2 < n && ny1 > -1 && ny1 < m && ny2 > -1 && ny2 < m) {
            ans = Math.max(ans, grid[i][j] + grid[nx1][ny1] + grid[nx2][ny2]);
        }

    }

    private static void cal(int i, int j) {
        block1(i, j);
        block2(i, j);
        block3(i, j);
        block4(i, j);
        block5(i, j);
        block6(i, j);
    }

}