import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }
        int ans = 0;
        while (check(arr)) {
            for (int i = n - 1; i > 0; i--) {
                if (arr[i] < arr[i - 1]) {
                    char temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean check(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return true;
            }
        }
        return false;
    }
}