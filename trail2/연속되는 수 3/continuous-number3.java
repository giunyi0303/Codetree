import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int count = 1;
        int answer = 1;
        if (arr[0] > 0) {
            flag = true;
        } else {
            flag = false;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] > 0) {
                if (flag) {
                    count++;
                    answer = Math.max(answer, count);

                } else {
                    answer = Math.max(answer, count);
                    count = 1;
                    flag = true;

                }
            } else {
                {
                    if (!flag) {
                        count++;
                        answer = Math.max(answer, count);
                    } else {
                        answer = Math.max(answer, count);
                        count = 1;
                        flag = false;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}