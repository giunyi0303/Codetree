import java.util.*;

public class Main {
    private static int[] A_info = new int[1000001];
    private static int[] B_info = new int[1000001];
    private static int A_time;
    private static int A_dis;
    private static int B_time;
    private static int B_dis;
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
            for (int j = 0; j < A[i][1]; j++) {
                A_time++;
                A_dis += A[i][0];
                A_info[A_time] = A_dis;
            }

        }

        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();
            for (int j = 0; j < B[i][1]; j++) {
                B_time++;
                B_dis += B[i][0];
                B_info[B_time] = B_dis;
            }
        }
        int index = Math.max(A_time, B_time);
        char winner = '0';
        for (int i = 1; i < index; i++) {
            if (winner == '0') {
                if (A_info[i] > B_info[i]) {
                    winner = 'A';
                } else if (A_info[i] < B_info[i]) {
                    winner = 'B';
                }
            } else {
                if (A_info[i] > B_info[i]) // A win
                {
                    if (winner == 'B') {
                        answer++;
                        winner = 'A';
                    }
                } else if (A_info[i] < B_info[i]) {
                    if (winner == 'A') {
                        answer++;
                        winner = 'B';
                    }

                }
            }

        }
        System.out.println(answer);

    }
}