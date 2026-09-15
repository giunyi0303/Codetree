import java.awt.Image;
import java.util.Scanner;

public class Main {
    private static int n;
    private static int t;
    private static int[] top;
    private static int[] bottom;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        top = new int[n];
        bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            change();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(top[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(bottom[i] + " ");
        }
    }

    private static void change() {
        int t1arr[] = new int[n];
        int t2arr[] = new int[n];
        t1arr[0] = bottom[n - 1];
        t2arr[0] = top[n - 1];
        for (int i = 1; i < n; i++) {
            t1arr[i] = top[i - 1];
            t2arr[i] = bottom[i - 1];
        }
        top = t1arr.clone();
        bottom = t2arr.clone();
    }
}