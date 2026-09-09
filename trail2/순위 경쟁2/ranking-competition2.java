import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int A = 0, B = 0;
        int ans = 0;

        char winner = 'C'; // 처음에는 A, B 공동 1등

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            int s = sc.nextInt();

            if (c == 'A') {
                A += s;
            } else {
                B += s;
            }

            char nextWinner;

            if (A > B) {
                nextWinner = 'A';
            } else if (A < B) {
                nextWinner = 'B';
            } else {
                nextWinner = 'C';
            }

            if (winner != nextWinner) {
                ans++;
            }

            winner = nextWinner;
        }

        System.out.println(ans);
    }
}
