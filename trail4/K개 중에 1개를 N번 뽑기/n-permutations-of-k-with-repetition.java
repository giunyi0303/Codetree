import java.util.Scanner;

public class Main {
    private static int k;
    private static int n;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];

        permutation(0);
    }

    private static void permutation(int count) {
        if (count == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[count] = i;
            permutation(count + 1);
        }
    }
}