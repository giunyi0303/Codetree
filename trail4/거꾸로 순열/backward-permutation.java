
import java.util.*;

public class Main {
    private static int[] arr;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];
        visited = new boolean[n + 1];

        per(0);
    }

    private static void per(int count) {
        if (count == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = n; i >=1; i--) {
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = i;

                per(count + 1);

                visited[i] = false;
            }
        }
    }
}