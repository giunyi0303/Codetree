import java.util.*;

public class Main {
    public static char[] d = new char[1000];
    public static int[] t = new int[1000];
    public static char[] d2 = new char[1000];
    public static int[] t2 = new int[1000];
    private static int[] A = new int[1000000];
    private static int[] B = new int[1000000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a_time = 0;
        int a_pos = 0;
        int b_time = 0;
        int b_pos = 0;

        for (int i = 0; i < n; i++) {
            d[i] = sc.next().charAt(0);
            t[i] = sc.nextInt();

            for (int j = 0; j < t[i]; j++) {
                if (d[i] == 'R') {
                    a_pos++;
                } else {
                    a_pos--;
                }

                A[a_time++] = a_pos;
            }
            
        }
        
        for (int i = 0; i < m; i++) {
            d2[i] = sc.next().charAt(0);
            t2[i] = sc.nextInt();
            for (int j = 0; j < t2[i]; j++) {
                if (d2[i] == 'R') {
                    b_pos++;
                } else {
                    b_pos--;
                }

                B[b_time++] = b_pos;
            }
        }

        int answer = -1;
        int limit = Math.min(a_time, b_time);

        for (int i = 0; i < limit; i++) {
            if (A[i] == B[i]) {
                answer = i + 1; // i는 0부터 시작하므로 실제 시간은 i + 1
                break;
            }
        }
        System.out.println(answer);

    }
}